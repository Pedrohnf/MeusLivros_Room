package com.example.phnf2014.meuslivros_room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface LivroDao {

    @Insert
    long Inserir(Livro livro);

    @Delete
    int Deletar(Livro livro);

    @Update
    int Atualizar(Livro livro);

    @Query("SELECT * FROM tabela_livro")
    Livro[] listAll();

    @Query("SELECT * FROM tabela_livro WHERE id = :id")
    Livro[] listById(long id);

}
