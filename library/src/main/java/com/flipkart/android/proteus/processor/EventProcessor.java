/*
 * Copyright 2016 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.android.proteus.processor;


import com.flipkart.android.proteus.Value;
import com.flipkart.android.proteus.toolbox.EventType;
import com.flipkart.android.proteus.toolbox.LayoutInflaterCallback;
import com.flipkart.android.proteus.view.ProteusView;

/**
 * Use this as the base processor for handling events like OnClick , OnLongClick , OnTouch etc.
 * Created by prateek.dixit on 20/11/14.
 */

public abstract class EventProcessor<T> extends AttributeProcessor<T> {

    @Override
    public void handle(T view, Value value) {
        setOnEventListener(view, value);
    }

    public abstract void setOnEventListener(T view, Value value);

    /**
     * This delegates Event with required attributes to client
     */
    public void fireEvent(ProteusView view, EventType eventType, Value parser) {
        LayoutInflaterCallback callback = view.getViewManager().getProteusLayoutInflater().getListener();
        if (null != callback) {
            callback.onEvent(view, eventType, parser);
        }
    }
}