package com.man.cavanha.androidcrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbGateway {

    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx){
        DbHelper helper = new DbHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
/*
Nesse DbGateway eu também usei o Design Pattern Singleton
para garantir que exista apenas um cliente de banco de dados
único paratodo o meu app, uma vez que o SQLite não trabalha
muito bem com concorrência e porque múltiplas conexões
poderiam consumir recursos demais.
*/