/*
 * Copyright (C) 2018 The Android Open Source Project
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
package me.scana.okgradle.internal.dsl.model.ext;

import me.scana.okgradle.internal.dsl.api.android.SigningConfigModel;
import me.scana.okgradle.internal.dsl.api.ext.SigningConfigPropertyModel;
import me.scana.okgradle.internal.dsl.model.android.SigningConfigModelImpl;
import me.scana.okgradle.internal.dsl.model.ext.GradlePropertyModelImpl;
import me.scana.okgradle.internal.dsl.model.ext.ResolvedPropertyModelImpl;
import me.scana.okgradle.internal.dsl.parser.android.SigningConfigDslElement;
import me.scana.okgradle.internal.dsl.parser.elements.GradleDslElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static me.scana.okgradle.internal.dsl.api.ext.GradlePropertyModel.ValueType.CUSTOM;

public class SigningConfigPropertyModelImpl extends ResolvedPropertyModelImpl implements SigningConfigPropertyModel {

  public SigningConfigPropertyModelImpl(@NotNull GradlePropertyModelImpl realModel) {
    super(realModel);
  }

  @Override
  @NotNull
  public ValueType getValueType() {
    if (resolveModel().getElement() instanceof SigningConfigDslElement) {
      return CUSTOM;
    } else {
      return super.getValueType();
    }
  }

  @Override
  @Nullable
  public SigningConfigModel toSigningConfig() {
    GradleDslElement element = resolveModel().getElement();
    if (!(element instanceof SigningConfigDslElement)) {
      return null;
    } else {
      return new SigningConfigModelImpl((SigningConfigDslElement)element);
    }
  }
}
