package com.jota.pruebalistview;

import android.provider.BaseColumns;

public class TablaBD {

    public static abstract class ProductoEntry implements BaseColumns {

        public static final String TABLE_NAME ="PRODUCTOS";
        public static final String NOMBRE  = "NOMBRE";
        public static final String VALOR = "VALOR";
    }
}