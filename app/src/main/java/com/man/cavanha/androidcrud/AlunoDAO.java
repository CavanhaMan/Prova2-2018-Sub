package com.man.cavanha.androidcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final String TABLE_ALUNOS = "Alunos";
    private DbGateway gw;

    public AlunoDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar(String nome, String nota){
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Nota", nota);
        return gw.getDatabase().insert(TABLE_ALUNOS, null, cv) > 0;
    }

    public List<Aluno> retornarTodos(){
        List<Aluno> alunos = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alunos", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String nota = cursor.getString(cursor.getColumnIndex("Nota"));
            alunos.add(new Aluno(id, nome, nota));
/*
            //MUDANDO A COR DAS BOLAS!
            //View v = findViewById(R.id.ballred);
            //v.setVisibility(View.VISIBLE);
            if (Integer.parseInt(nota)<6){
                R.id.ballblack.setVisibility(View.INVISIBLE);
                R.id.ballred.setVisibility(View.VISIBLE);
                R.id.ballblue.setVisibility(View.INVISIBLE);
            }
            else{
                R.id.ballblack.setVisibility(View.INVISIBLE);
                R.id.ballred.setVisibility(View.INVISIBLE);
                R.id.ballblue.setVisibility(View.VISIBLE);
            }
*/
        }
        cursor.close();
        return alunos;
    }

    public Aluno retornarUltimo(){
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Alunos ORDER BY ID DESC", null);
        if(cursor.moveToFirst()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            String nota = cursor.getString(cursor.getColumnIndex("Nota"));
            cursor.close();
            return new Aluno(id, nome, nota);
        }

        return null;
    }
}