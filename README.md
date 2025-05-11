# 🎬 IMDb - Android App

Esta es una aplicación de películas desarrollada en **Android Studio** utilizando **Kotlin** y basada en la API de [The Movie DB](https://api.themoviedb.org/3). La app permite explorar películas populares, registrarse, iniciar sesión, consultar detalles y recomendaciones de películas, y más.

## 📱 Tecnologías y Arquitectura

- **Jetpack Compose** para la UI moderna y declarativa  
- **Room** para persistencia local de datos  
- **Retrofit** para el consumo de APIs  
- **MVVM & MVI** para el manejo de estados y lógica de presentación  
- **Coroutines & Flow** para la programación asíncrona y reactiva  
- **Hilt** para inyección de dependencias  
- **Clean Architecture** para mantener una estructura desacoplada y escalable  
- **GIT** para control de versiones  
- **Unit Testing** con `mockk` y pruebas de ViewModels  
- **UI Testing** con Espresso (Proyecto avanzado)  
- **Jacoco** para medición de cobertura de pruebas (Proyecto avanzado)  
- **Modularización** del código (Proyecto avanzado)  

---

## ✅ Requisitos funcionales implementados

### Proyecto Base

- Pantalla de **splash** con animación de 1.5 segundos y validación de login persistido  
- Pantalla de **login** con persistencia local  
- Pantalla de **registro** con validaciones:
  - Mínimo 8 caracteres  
  - Una mayúscula, una minúscula  
  - Un carácter especial y un número  
  - Verificación de email duplicado  
- Pantalla de **búsqueda** con filtro por nombre y resultados obtenidos desde TMDB  
- **Diagrama de arquitectura** incluido en la documentación del proyecto  

### Detalles como:

- Pantalla de **inicio** mostrando:
  - La película más popular en destaque  
  - Carrusel de películas populares (excluyendo la destacada)  
  - Carrusel de mejores calificadas  
- Pantalla de **detalle** mostrando información y recomendaciones basadas en la película  
---

## 🔗 API e Imágenes

La aplicación usa [TMDB API](https://api.themoviedb.org/3) con la clave pública:

```
API Key: c5c47722a4adcc77f6e84f28a48b857a
```

### Endpoints utilizados

- `movie/popular` – Películas populares  
- `movie/top_rated` – Mejores calificadas  
- `movie/{movie_id}/recommendations` – Recomendaciones por película  

### Formato de imágenes

Las imágenes se generan concatenando:

```
URL base: https://image.tmdb.org/t/p/w500/
Ejemplo: https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg
```

---

## 🧪 Pruebas

- **Unit Tests** con cobertura mínima del 80% (`Jacoco`)  
- **UI Tests** con Espresso  
- Cobertura de pruebas para ViewModel, Repository y UseCases  

---

## 🎨 Diseño UI

Diseño basado en [Adobe XD mockup](https://xd.adobe.com/view/feafd6f3-3f73-47c1-99d8-f7f11e5f7ac9-abfc/screen/1759965c-25c5-4b09-b4eb-07d1118ee139/)

---

## 📸 App funcional 


