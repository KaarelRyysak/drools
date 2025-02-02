/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
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

package org.kie.dmn.core.compiler.alphanetbased;

import java.util.Optional;

import org.drools.ancompiler.CompiledNetwork;
import org.drools.core.reteoo.ObjectTypeNode;
import org.kie.dmn.feel.lang.EvaluationContext;
import org.kie.dmn.feel.runtime.decisiontables.DecisionTable;
import org.kie.dmn.feel.runtime.events.InvalidInputEvent;

public interface DMNCompiledAlphaNetwork {

    void initRete();

    void setCompiledAlphaNetwork(CompiledNetwork compiledAlphaNetwork);

    ObjectTypeNode getObjectTypeNode();

    Optional<InvalidInputEvent> validate(EvaluationContext evaluationContext);

    Object evaluate(EvaluationContext evaluationContext, DecisionTable decisionTable);

    ResultCollector getResultCollector();

}
