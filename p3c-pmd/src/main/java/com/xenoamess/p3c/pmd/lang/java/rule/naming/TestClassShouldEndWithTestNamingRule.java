/*
 * Copyright 1999-2017 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xenoamess.p3c.pmd.lang.java.rule.naming;

import com.xenoamess.p3c.pmd.I18nResources;
import com.xenoamess.p3c.pmd.lang.java.util.ViolationUtils;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.rule.AbstractJUnitRule;

import java.util.List;

/**
 * [Mandatory] Test cases shall be started with the class names to be tested and ended with Test.
 *
 * @author changle.lq
 * @date 2017/04/16
 */
public class TestClassShouldEndWithTestNamingRule extends AbstractJUnitRule {
    private static final String TEST_SUFFIX = "Test";

    @Override
    public Object visit(ASTClassOrInterfaceDeclaration node, Object data) {
        boolean oldJunit3Class = isJUnit3Class;
        boolean oldJunit4Class = isJUnit4Class;
        boolean oldJunit5Class = isJUnit5Class;

        Object res;
        try {
            analyzeJUnitClass(node);
            res = this.visitInternal(node, data);
        } finally {
            isJUnit3Class = oldJunit3Class;
            isJUnit4Class = oldJunit4Class;
            isJUnit5Class = oldJunit5Class;
        }

        return res;
    }

    private Object visitInternal(ASTClassOrInterfaceDeclaration node, Object data) {
        if (node.isAbstract() || node.isInterface() || node.isNested()) {
            return super.visit(node, data);
        }

        List<ASTMethodDeclaration> m = node.findDescendantsOfType(ASTMethodDeclaration.class);
        boolean testsFound = false;

        if (m != null) {
            for (ASTMethodDeclaration md : m) {
                if (!isInInnerClassOrInterface(md) && isJUnitMethod(md, data)) {
                    testsFound = true;
                }
            }
        }

        if ((testsFound) && (!(node.getSimpleName().endsWith(TEST_SUFFIX)))) {
            ViolationUtils.addViolationWithPrecisePosition(this, node, data,
                    I18nResources.getMessage("java.naming.TestClassShouldEndWithTestNamingRule.violation.msg",
                            node.getSimpleName()));
        }

        return super.visit(node, data);
    }

    private boolean isInInnerClassOrInterface(ASTMethodDeclaration md) {
        ASTClassOrInterfaceDeclaration p = md.getFirstParentOfType(ASTClassOrInterfaceDeclaration.class);
        return p != null && p.isNested();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(I18nResources.getMessageWithExceptionHandled(description));
    }

    @Override
    public void setMessage(String message) {
        super.setMessage(I18nResources.getMessageWithExceptionHandled(message));
    }

    @Override
    public void addViolationWithMessage(Object data, Node node, String message) {
        if (ViolationUtils.shouldIgnoreViolation(this.getClass(), node)) {
            return;
        }
        super.addViolationWithMessage(data, node, I18nResources.getMessageWithExceptionHandled(message));
    }

    @Override
    public void addViolationWithMessage(Object data, Node node, String message, Object[] args) {
        if (ViolationUtils.shouldIgnoreViolation(this.getClass(), node)) {
            return;
        }
        super.addViolationWithMessage(data, node,
                String.format(I18nResources.getMessageWithExceptionHandled(message), args));
    }
}
