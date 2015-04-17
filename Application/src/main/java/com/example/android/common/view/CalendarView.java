/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.example.android.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

public class CalendarView extends View {
    private ShapeDrawable mDrawable;
    private int m_data;

    Paint paint = new Paint();
    Canvas mCanvas;

    public CalendarView(Context context) {
        super(context);
    }

    public CalendarView(Context context, int temp) {
        super(context);
        m_data = temp;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mCanvas = canvas;
        int width = mCanvas.getWidth();
        super.onDraw(canvas);

        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        int start = 8;
        int hour_vertical_interval = 100;
        int hour_width = 100;

        paint.setAntiAlias(true);
        for (int i = start; i < start+10; i++){
            int y = (i - start + 1) * hour_vertical_interval;
            canvas.drawText(i + ":00", 10, y, paint);
            canvas.drawLine(hour_width, y-10, width, y-10, paint);
        }
        canvas.drawRect(hour_width, hour_vertical_interval, hour_width + (width-hour_width)/7, hour_vertical_interval+10, paint);
    }
}