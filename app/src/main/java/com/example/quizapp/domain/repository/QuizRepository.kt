package com.example.quizapp.domain.repository

import com.example.quizapp.domain.model.Question

interface QuizRepository {
    suspend fun getQuestions(limit: Int, categories: String): List<Question>
}
