package org.jiakesimk.minipika.framework.factory;

/* ************************************************************************
 *
 * Copyright (C) 2020 tiansheng All rights reserved.
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
 *
 * ************************************************************************/

/*
 * Creates on 2020/6/2.
 */

import org.jiakesimk.minipika.components.mql.FaceAgent;
import org.jiakesimk.minipika.framework.context.ContextManager;

/**
 * @author tiansheng
 * @email jiakesiws@gmail.com
 */
public class Factorys {

  static {
    ContextManager.loadContext(); // 加载上下文
  }

  public static <T> T forClass(Class<T> clazz) {
    return ComponentContainer.factory.forClass(clazz);
  }

  public static <T> T forClass(Class<?> clazz, Class<?>[] types, Object... parameter) {
    return ComponentContainer.factory.forClass(clazz, types, parameter);
  }

  @SuppressWarnings("unchecked")
  public static <T> T forMapper(Class<T> clazz) {
    String name = clazz.getName();
    T iface = (T) ComponentContainer.components.get(name);
    if (iface == null) {
      FaceAgent<T> callback = Factorys.forClass(FaceAgent.class,
              new Class[]{Class.class}, clazz);
      iface = callback.bind();
      ComponentContainer.components.put(name, iface);
    }
    return iface;
  }

}
