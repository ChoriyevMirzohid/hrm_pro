
// Uzbek language
let lang_uz = {
    word_1: "Login yoki parol xato!",
    word_2: "Login",
    word_3: "Parol",
    word_4: "Eslab qolmoq",
    word_5: "Kirish",
    word_6: "Xodimlar"
}

let lang_ru = {
    word_1: "Ошибка логина или пароля!",
    word_2: "Логин",
    word_3: "Пароль",
    word_4: "Запомнить",
    word_5: "Войти",
    word_6: "Сотрудники"
}

let lang_en = {
    word_1: "Wrong login or password!",
    word_2: "Login",
    word_3: "Password",
    word_4: "Remember",
    word_5: "Sign in",
    word_6: "Employees"
}
let loc = window.location.pathname.substring(1);
if (localStorage.getItem("sys_lang") === "UZB"){
    // Uzbek language
    if (loc==="login") {
        document.getElementById("word_1").innerHTML = lang_uz.word_1;
        document.getElementById("word_2").innerHTML = lang_uz.word_2;
        document.getElementById("word_3").innerHTML = lang_uz.word_3;
        document.getElementById("word_4").innerHTML = lang_uz.word_4;
        document.getElementById("word_5").innerHTML = lang_uz.word_5;
    }
    if (loc==="dashboard") {
        document.getElementById("word_6").innerHTML = lang_uz.word_6;
    }
} else if (localStorage.getItem("sys_lang") === "RUS" || localStorage.getItem("sys_lang") === null){
    // Russsian language
    if (loc==="login") {
        document.getElementById("word_1").innerHTML = lang_ru.word_1;
        document.getElementById("word_2").innerHTML = lang_ru.word_2;
        document.getElementById("word_3").innerHTML = lang_ru.word_3;
        document.getElementById("word_4").innerHTML = lang_ru.word_4;
        document.getElementById("word_5").innerHTML = lang_ru.word_5;
    }
    if (loc==="dashboard") {
        document.getElementById("word_6").innerHTML = lang_ru.word_6;
    }
} else if (localStorage.getItem("sys_lang") === "ENG"){
    // English language
    if (loc==="login") {
        document.getElementById("word_1").innerHTML = lang_en.word_1;
        document.getElementById("word_2").innerHTML = lang_en.word_2;
        document.getElementById("word_3").innerHTML = lang_en.word_3;
        document.getElementById("word_4").innerHTML = lang_en.word_4;
        document.getElementById("word_5").innerHTML = lang_en.word_5;
    }
    if (loc==="dashboard") {
        document.getElementById("word_6").innerHTML = lang_en.word_6;
    }
}
