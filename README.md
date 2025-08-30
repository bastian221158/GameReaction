# Bastián Parraguez y Diego Carrasco

# 📱 Juego de Reacción

---

## 📌 Preguntas obligatorias (responde todas en tu post)

### 1.- Nombre de la App  
**R.** Juego de Reacción  

---

### 2.- Propósito y problema que resuelve  
**R.**  
- **¿Para quién?** Personas que buscan entretenimiento rápido y sencillo, tipo juego casual.  
- **¿Qué aporta?** Diversión breve y reto personal (competir con uno mismo o amigos). Entrena reflejos y rapidez mental.  

---

### 3.- Pantallas iniciales (Activities)  
**R.**  
- **Pantalla de Inicio**: Botón para empezar a jugar y ver puntajes anteriores.  
- **Pantalla de Juego**: Fondo cambia de color en un tiempo aleatorio → el usuario debe tocar rápido.  
- **Pantalla de Resultados**: Muestra el tiempo de reacción y ranking de mejores tiempos.  

---

### 4.- Navegación entre pantallas  
**R.**  
- **MainActivity → JuegoActivity**  
  - Intent explícito.  

- **JuegoActivity → ResultadoActivity**  
  - Intent explícito con **Extras**: tiempo de reacción obtenido (`"reactionTime"`).  

- **ResultadoActivity → MainActivity**  
  - Intent explícito para volver al menú.  

---

### 5.- Componentes de Android que se prevén usar  
**R.**  
- **Activities**: Para cada pantalla (Inicio, Juego, Resultados).  
- **Intents**: Navegación entre Activities y paso de datos (tiempo de reacción).  
- **SharedPreferences**: Guardar mejores tiempos del jugador (fuente de datos interna).  
- **View Components**: Buttons, TextViews, Layout con cambio dinámico de color.  
- **Handler/Timer**: Para manejar el retardo aleatorio antes de que cambie el color.  

---

### 6.- Datos  
**R.**  
- Últimos tiempos de reacción.  
- Mejor tiempo histórico.  
- **Fuente**: `SharedPreferences` (persistencia básica en el dispositivo).  

---

### 7.- Riesgos o desafíos iniciales  
**R.**  
1. Manejo del tiempo aleatorio y detección precisa del “tap” del usuario.  
2. Evitar que el usuario haga *trampa* tocando antes del cambio de color.  
3. Diseño atractivo y minimalista para que el juego no se sienta demasiado básico.  

---

### 8.- Hitos de avance  
**R.**  
- **Hito 1**: Crear pantallas básicas (Activities + layouts) y navegación con Intents.  
- **Hito 2**: Implementar lógica del juego (cambio de color aleatorio + captura de tiempo).  
- **Hito 3**: Guardar y mostrar resultados en ranking usando `SharedPreferences`.  

---
