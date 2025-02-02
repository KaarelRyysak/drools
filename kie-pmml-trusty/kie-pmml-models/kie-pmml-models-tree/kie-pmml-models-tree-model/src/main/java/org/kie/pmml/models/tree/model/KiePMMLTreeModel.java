/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package  org.kie.pmml.models.tree.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import org.kie.pmml.commons.model.KiePMMLModel;

public class KiePMMLTreeModel extends KiePMMLModel {

    private static final long serialVersionUID = -5158590062736070465L;

    protected Function<Map<String, Object>, KiePMMLNodeResult> nodeFunction;
    private LinkedHashMap<String, Double> probabilityResultMap;

    public KiePMMLTreeModel(String modelName) {
        super(modelName, Collections.emptyList());
    }

    @Override
    public Object evaluate(final Object knowledgeBase, final Map<String, Object> requestData) {
        KiePMMLNodeResult kiePMMLNodeResult = nodeFunction.apply(requestData);
        probabilityResultMap = kiePMMLNodeResult.getProbabilityMap();
        return kiePMMLNodeResult.getScore();
    }

    @Override
    public LinkedHashMap<String, Double> getProbabilityResultMap() {
        return probabilityResultMap;
    }

}
