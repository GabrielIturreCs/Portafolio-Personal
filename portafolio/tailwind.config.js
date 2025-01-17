/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class', // Usa 'media' para basarte en la configuración del sistema o 'class' para alternar manualmente
  content: [
    "./index.html", // Asegúrate de agregar la ruta de tu archivo HTML
    "./src/**/*.{html,js,css}" // Asegúrate de que Tailwind también escanee los archivos JS y CSS si los usas
  ],

  theme: {
    extend: {
      colors: {
        primary: '#1da1f2', // Azul personalizado
        secondary: '#ffad1f', // Amarillo personalizado
      },
    },
  },

  plugins: [],
};