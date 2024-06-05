
// Uzbek language
let lang_uz = {
    word_1: "Boshqaruv paneli",
    word_2: ""
}
let lang_ru = {
    word_1: "Панель управления",
    word_2: ""
}
let lang_en = {
    word_1: "Dashboard",
    word_2: ""
}

if (localStorage.getItem("sys_lang") === "UZB"){
    // Uzbek language
    document.getElementById("word_1").innerHTML=lang_uz.word_1;
} else if (localStorage.getItem("sys_lang") === "RUS"){
    // Russsian language
    document.getElementById("word_1").innerHTML=lang_ru.word_1;
} else if (localStorage.getItem("sys_lang") === "ENG"){
    // English language
    document.getElementById("word_1").innerHTML=lang_en.word_1;
}
