// Palabras que se escribirán
const words = ["Desarrollador Web Frontend"];
let index = 0;
const dynamicText = document.getElementById("dynamic-text");

// Función para borrar y escribir el texto
function typeAndErase() {
  let word = words[index];
  let i = 0;
  dynamicText.textContent = '';

  // Escribir el texto
  let typingInterval = setInterval(() => {
    dynamicText.textContent += word[i];
    i++;
    if (i === word.length) {
      clearInterval(typingInterval);
      setTimeout(erase, 1500); // Espera antes de borrar
    }
  }, 100); // Velocidad de escritura
}

// Función para borrar el texto
function erase() {
  let i = dynamicText.textContent.length;
  let erasingInterval = setInterval(() => {
    dynamicText.textContent = dynamicText.textContent.slice(0, i - 1);
    i--;
    if (i === 0) {
      clearInterval(erasingInterval);
      index = (index + 1) % words.length; // Cambiar palabra
      typeAndErase();
    }
  }, 50); // Velocidad de borrado
}

// Iniciar la animación de escritura
typeAndErase();