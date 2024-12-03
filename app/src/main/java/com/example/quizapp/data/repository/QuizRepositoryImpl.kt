package com.example.quizapp.data.repository

import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.domain.model.Question
import com.example.quizapp.domain.repository.QuizRepository

class QuizRepositoryImpl(
    private val api: QuizApi
) : QuizRepository {
    override suspend fun getQuestions(limit: Int, categories: String): List<Question> {
        return api.getQuestions(limit, categories).map {
            Question(
                id = it.id,
                question = it.question,
                correctAnswer = it.correctAnswer,
                incorrectAnswers = it.incorrectAnswers,
                category = it.category
            )
        }
    }
}
