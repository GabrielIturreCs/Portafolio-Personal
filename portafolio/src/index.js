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
const mobileMenu = document.getElementById('mobile-menu');
let isMenuOpen = false; // Variable para verificar si el menú está abierto

// Función para ocultar el navbar al hacer scroll (solo en pantallas grandes)
window.addEventListener('scroll', () => {
  // Solo ejecutar este código en pantallas grandes (escritorios)
  if (window.innerWidth > 1036) {
    // Si el menú está abierto, no permitir que el usuario haga scroll
    if (isMenuOpen) {
      window.scrollTo(0, lastScrollY); // Bloquea el scroll, manteniendo la posición
      return; // Detener la ejecución del scroll
    }

    // Ocultar el navbar al hacer scroll hacia abajo
    if (window.scrollY > lastScrollY) {
      navbar.style.transform = 'translateY(-100%)'; // Oculta el navbar
    } else {
      navbar.style.transform = 'translateY(0)'; // Muestra el navbar
    }
  }

  lastScrollY = window.scrollY;
});

// Seleccionar elementos
const openMenuButton = document.getElementById('menu-open-btn');
const closeMenuButton = document.getElementById('menu-close-btn');
const mobileNav = document.getElementById('mobile-nav');
const navLinks = document.querySelectorAll('#mobile-nav a'); // Opciones del menú móvil
let isMenuVisible = false; // Estado inicial del menú

// Mostrar el menú móvil
function showMobileMenu() {
  mobileNav.style.transition = 'transform 0.3s ease-in-out';
  mobileNav.style.transform = 'translateY(0)';
  isMenuVisible = true;
  document.body.style.overflow = 'hidden'; // Deshabilitar scroll
}

// Ocultar el menú móvil
function hideMobileMenu() {
  mobileNav.style.transition = 'transform 0.3s ease-in-out';
  mobileNav.style.transform = 'translateY(-100%)';
  isMenuVisible = false;
  document.body.style.overflow = 'auto'; // Habilitar scroll
}

// Mostrar menú al hacer clic en el botón de hamburguesa
openMenuButton.addEventListener('click', showMobileMenu);

// Cerrar menú al hacer clic en el botón de cerrar
closeMenuButton.addEventListener('click', hideMobileMenu);

// Cerrar menú al hacer clic en una opción del menú
navLinks.forEach(link => {
  link.addEventListener('click', hideMobileMenu);
});

// Detectar tamaño de pantalla para restablecer estado del menú
window.addEventListener('resize', () => {
  if (window.innerWidth > 1024) {
    // Si se pasa a pantalla grande, ocultar el menú móvil y habilitar el scroll
    mobileNav.style.transform = 'translateY(-100%)';
    document.body.style.overflow = 'auto';
    isMenuVisible = false;
  }
});

// Evitar scroll en pantallas táctiles si el menú está abierto
window.addEventListener('touchmove', (e) => {
  if (isMenuVisible) {
    e.preventDefault();
  }
});








// ================================================================= Mejora UX================================================================= //
 // ================================================================= Mejora formulario================================================================= //



document.getElementById("contact-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Evita que se envíe automáticamente
  
  // Muestra la notificación de "Enviando..."
  document.getElementById("notification-sending").classList.remove("hidden");
  
  // Simula el envío del formulario
  setTimeout(function() {
    // Después de 2 segundos (simulando envío), oculta la notificación de "Enviando..." y muestra "Enviado con éxito"
    document.getElementById("notification-sending").classList.add("hidden");
    document.getElementById("notification-success").classList.remove("hidden");

    // Aquí es donde puedes enviar el formulario real si todo está funcionando
    event.target.submit();
  }, 2000);
});
// para el botom el tilde de enviado en el formulario //
document.getElementById('contact-form').addEventListener('submit', function(e) {
  e.preventDefault(); // Prevenir el envío automático del formulario

  var submitButton = document.getElementById('submit-button');
  var buttonText = document.getElementById('button-text');
  var loadingIcon = document.getElementById('loading-icon');
  var notificationSending = document.getElementById('notification-sending');
  var notificationSuccess = document.getElementById('notification-success');

  // Mostrar icono de carga y deshabilitar el botón
  loadingIcon.classList.remove('hidden');
  buttonText.textContent = 'Enviando...';
  submitButton.disabled = true;
  notificationSending.classList.remove('hidden');

  // Enviar el formulario
  this.submit();

  // Después de enviar, mostrar el mensaje de éxito
  setTimeout(function() {
    notificationSending.classList.add('hidden');
    notificationSuccess.classList.remove('hidden');
    buttonText.textContent = 'Enviado con éxito 🎉';
  }, 2000); // 3 segundos de espera antes de mostrar el éxito
});

document.addEventListener('DOMContentLoaded', () => {
  const starsContainer = document.querySelector('.stars');
  for (let i = 0; i < 100; i++) { // Agregar 100 estrellas
    const star = document.createElement('div');
    star.classList.add('star');
    star.style.left = `${Math.random() * 100}vw`; // Posición aleatoria horizontal
    star.style.animationDuration = `${Math.random() * 5 + 2}s`; // Duración aleatoria
    star.style.animationDelay = `${Math.random() * 3}s`; // Retraso aleatorio
    starsContainer.appendChild(star);
  }
});