package com.example.myawstest

import com.amplifyframework.core.model.Model
import com.amplifyframework.core.model.annotations.ModelConfig
import com.amplifyframework.core.model.annotations.ModelField
import java.util.UUID

@ModelConfig(pluralName = "Persons")
data class Person(
    @ModelField(targetType = "ID", isRequired = true)
    val id: String = UUID.randomUUID().toString(),

    @ModelField(targetType = "String", isRequired = true)
    val name: String,

    @ModelField(targetType = "String", isRequired = true)
    val lastName: String
) : Model
