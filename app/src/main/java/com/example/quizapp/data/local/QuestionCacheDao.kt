package com.example.quizapp.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizapp.domain.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionCacheDao {

    @Query("DELETE FROM questions_table")
    suspend fun clear()

    @Query("SELECT * FROM questions_table")
    fun getQuestions(): Flow<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)


}