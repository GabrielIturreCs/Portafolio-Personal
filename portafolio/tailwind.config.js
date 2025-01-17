/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class', // Usa 'media' para basarte en la configuración del sistema o 'class' para alternar manualmente
  content: ["./src/**/*.{html,js}"],

  theme: {
    extend: {
      colors: {
        primary: '#1da1f2', // Azul personalizado
        secondary: '#ffad1f', // Amarillo personalizado
      },
    },
  },
};