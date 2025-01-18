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

document.addEventListener('DOMContentLoaded', function () {
  // Obtener todos los elementos con la clase fade-in
  const fadeInElements = document.querySelectorAll('.fade-in');

  // Función para verificar si un elemento está en el viewport
  function checkVisibility() {
      fadeInElements.forEach((el) => {
          const rect = el.getBoundingClientRect();
          if (rect.top <= window.innerHeight && rect.bottom >= 0) {
              el.classList.add('visible');
          }
      });
  }

  // Agregar la clase visible a los elementos cuando están en el viewport
  window.addEventListener('scroll', checkVisibility);

  // Llamar la función al cargar la página para mostrar los elementos ya visibles
  checkVisibility();
});

// Función para ocultar el navbar al hacer scroll
let lastScrollY = window.scrollY;
const navbar = document.getElementById('navbar');

window.addEventListener('scroll', () => {
  if (window.scrollY > lastScrollY) {
    navbar.style.transform = 'translateY(-100%)'; // Oculta el navbar
  } else {
    navbar.style.transform = 'translateY(0)'; // Muestra el navbar
  }
  lastScrollY = window.scrollY;
});

// Funcionalidad para el menú móvil
const hamburgerBtn = document.getElementById('hamburger-btn');
const mobileMenu = document.getElementById('mobile-menu');
const closeMenu = document.getElementById('close-menu');

hamburgerBtn.addEventListener('click', () => {
  mobileMenu.style.transform = 'translateY(0)'; // Muestra el menú móvil
});

closeMenu.addEventListener('click', () => {
  mobileMenu.style.transform = 'translateY(-100%)'; // Oculta el menú móvil
});



// Seleccionar elementos  seccion formulario
const form = document.getElementById("contact-form");
const notificationSending = document.getElementById("notification-sending");
const notificationSuccess = document.getElementById("notification-success");
const successSound = document.getElementById("success-sound");

// Manejar envío del formulario
form.addEventListener("submit", (e) => {
  e.preventDefault(); // Prevenir el envío por defecto

  // Mostrar notificación de "Enviando..."
  notificationSending.classList.remove("hidden");

  // Simular un retraso para mostrar "Enviado con éxito"
  setTimeout(() => {
    notificationSending.classList.add("hidden"); // Ocultar "Enviando..."
    notificationSuccess.classList.remove("hidden"); // Mostrar "Enviado con éxito"
    successSound.play(); // Reproducir sonido

    // Ocultar la notificación de éxito después de 3 segundos
    setTimeout(() => {
      notificationSuccess.classList.add("hidden");
    }, 3000);

    // Reiniciar el formulario
    form.reset();
  }, 2000);
});


//boton enviar js para el verificado*//

const form2 = document.getElementById('contact-form');
const submitButton = document.getElementById('submit-button');
const buttonText = document.getElementById('button-text');

form.addEventListener('submit', (e) => {
  e.preventDefault(); // Evita el envío automático para mostrar el cambio

  // Cambiar texto del botón a un ícono de check
  buttonText.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" /></svg>';
  submitButton.classList.add('bg-green-500', 'hover:bg-green-600');
  submitButton.classList.remove('bg-blue-500', 'hover:bg-blue-600');

  // Restaurar el botón tras 3 segundos
  setTimeout(() => {
    buttonText.innerHTML = 'Enviar';
    submitButton.classList.add('bg-blue-500', 'hover:bg-blue-600');
    submitButton.classList.remove('bg-green-500', 'hover:bg-green-600');
    form.submit(); // Enviar el formulario después de restaurar el botón
  }, 3000);
});

//funcion para que se quede en la sitio web en contacto//
document.getElementById("contact-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Previene que el formulario se envíe de manera tradicional

  // Mostrar notificación de que se está enviando
  document.getElementById("notification-sending").classList.remove("hidden");

  // Recoger los datos del formulario
  const formData = new FormData(this);

  // Enviar los datos del formulario usando fetch
  fetch("https://formsubmit.co/gabriel15iturre@gmail.com", {
    method: "POST",
    body: formData
  })
  .then(response => {
    if (response.ok) {
      // Si el envío fue exitoso
      document.getElementById("notification-sending").classList.add("hidden");
      document.getElementById("notification-success").classList.remove("hidden");

      // Opcional: Resetea el formulario después de enviarlo
      document.getElementById("contact-form").reset();
    } else {
      // Si hubo un error en el envío
      alert("Hubo un error al enviar el mensaje.");
    }
  })
  .catch(error => {
    console.error("Error al enviar el formulario:", error);
    alert("Hubo un error al enviar el mensaje.");
  });
});