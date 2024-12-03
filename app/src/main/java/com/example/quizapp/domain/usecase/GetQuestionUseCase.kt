package com.example.quizapp.domain.usecase

import android.util.Log
import com.example.quizapp.domain.model.Question
import com.example.quizapp.domain.repository.QuizRepository

class GetQuestionUseCase(private val repository: QuizRepository) {
    suspend operator fun invoke(limit: Int, categories: String): List<Question> {
        Log.d("GetQuestionUseCase", "Invoking API call with limit: $limit and categories: $categories")

        val questions = repository.getQuestions(limit, categories)
        Log.d("GetQuestionUseCase", "Received ${questions.size} questions.")

        return questions
    }
}

