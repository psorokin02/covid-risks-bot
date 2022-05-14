package ru.spbstu.user

import org.springframework.beans.factory.annotation.Value
import org.telegram.telegrambots.meta.api.objects.Message

enum class UserBotState() {

    GREETING{
        override val next get() = START
        override val prev get() = GREETING
        override val message = "Привет, это бот оценки рисков заражения covid-19\n" +
                "Вам необходимо будет заполнить анкету из нескольких вопросов\n\n" +
                "Напишите \"go\", чтобы начать"
    },

    START{
        override val next get() = AGE
        override val prev get() = GREETING
        override val message = "Сколько вам лет (число от 1 до 100)"
    },

    AGE{
        override val next get() = GENDER
        override val prev get() = START
        override val message = "Ваш пол (м/ж)"
    },

    GENDER{
        override val next get() = WAS_ILL
        override val prev get() = AGE
        override val message = "Болели ли вы короновирусом и как сильно?\n" +
                "Отправьте цифру от 0 до 10, где: \n" +
                "0 - не болел\n" +
                "10 - болел очень серьезно"
    },

    WAS_ILL{
        override val next get() = WAS_VACCINE
        override val prev get() = GENDER
        override val message = "Вакцинировались ли вы?\n" +
                "Отправьте цифру от 1 до 6, где: \n" +
                "1. Больше года назад\n" +
                "2. Больше 6 месяцев назад\n" +
                "3. Больше 3 месяцев назад\n" +
                "4. Больше 1 месяца назад\n" +
                "5. Меньше одного месяца назад\n" +
                "6. Не вакцинировался\n"
    },

    WAS_VACCINE{
        override val next get() = PLACES_FREQUENCY
        override val prev get() = WAS_ILL
        override val message = "Как часто вы посещаете места скопления большого количества людей?\n" +
                "Отправьте цифру от 1 до 10, где: \n" +
                "1 - почти не выхожу из дома\n" +
                "10 - каждый день куда-нибудь иду"
    },

    PLACES_FREQUENCY{
        override val next get() = MASK
        override val prev get() = WAS_VACCINE
        override val message = "Носите ли вы маску?\n" +
                "Отправьте цифру от 1 до 5, где: \n" +
                "1. Да, всегда и везде\n" +
                "2. Обычно ношу\n" +
                "3. Ношу только если просят\n" +
                "4. Обычно не ношу\n" +
                "5. Не ношу, категорически против ношения масок\n"
    },

    MASK{
        override val next get() = POPULATION
        override val prev get() = PLACES_FREQUENCY
        override val message = "Сколько население в вашем городе?\n" +
                "Отправьте цифру от 1 до 7, где: \n" +
                "1. Больше 10 миллионов\n" +
                "2. Больше 5 миллионов\n" +
                "3. Больше 1 миллиона\n" +
                "4. Больше 500 тысяч\n" +
                "5. Больше 100 тысяч\n" +
                "6. Больше 10 тысяч\n" +
                "7. Меньше 10 тысяч\n"
    },

    POPULATION{
        override val next get() = START
        override val prev get() = MASK
        override val message = "Отлично, анкта заполнена"
    };

//    GOT_RESULT {
//        override val next get() = START
//        override val prev get() = POPULATION
//        override val message = "Напишите \"go\", чтобы пройти опрос еще раз"
//    };

    abstract val next: UserBotState
    abstract val prev: UserBotState
    abstract val message: String

    fun ask(): Pair<String, UserBotState> = this.message to this.next
    fun wrongAnswer(): Pair<String, UserBotState> = this.prev.message to this
}
