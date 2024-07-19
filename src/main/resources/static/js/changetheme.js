function myFunction(){
    var element = document.body;
    var theme = element.dataset.bsTheme == "light" ? "dark" : "light";
    element.dataset.bsTheme = theme;
    document.cookie = "theme=" + theme + "; path=/;";
    // Cambia il link del foglio di stile
    var link = document.querySelector('link[rel=stylesheet][href*="theme.css"]');
    if (link) {
        link.href = theme + "-theme.css";
    } else {
        // Aggiungi un nuovo link se non esiste
        link = document.createElement('link');
        link.rel = 'stylesheet';
        link.href = theme + "-theme.css";
        document.head.appendChild(link);
    }
}

// Funzione per ottenere il valore del cookie
function getCookie(name) {
    let cookieArr = document.cookie.split(";");
    for (let i = 0; i < cookieArr.length; i++) {
        let cookiePair = cookieArr[i].split("=");
        if (name == cookiePair[0].trim()) {
            return decodeURIComponent(cookiePair[1]);
        }
    }
    return null;
}

// Al caricamento della pagina, imposta il tema
document.addEventListener("DOMContentLoaded", function() {
    var theme = getCookie("theme") || "dark";
    document.body.dataset.bsTheme = theme;
    var link = document.querySelector('link[rel=stylesheet][href*="theme.css"]');
    if (link) {
        link.href = theme + "-theme.css";
    } else {
        // Aggiungi un nuovo link se non esiste
        link = document.createElement('link');
        link.rel = 'stylesheet';
        link.href = theme + "-theme.css";
        document.head.appendChild(link);
    }
});