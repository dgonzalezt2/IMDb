# 🎬 IMDb - Android App

Esta es una aplicación de películas desarrollada en **Android Studio** utilizando **Kotlin** y basada en la API de [The Movie DB](https://api.themoviedb.org/3). La app permite explorar películas populares, registrarse, iniciar sesión, consultar detalles y recomendaciones de películas, y más.

## 📱 Tecnologías y Arquitectura

- **Jetpack Compose Y Layouts(XML)** para la UI moderna y declarativa  
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
- Pantalla de **búsqueda** con filtro por nombre y resultados obtenidos desde TMDB  


### La app tiene detalles como:

- Pantalla de **inicio** mostrando:
  - La película más popular en destaque  
  - Carrusel de películas populares (excluyendo la destacada)  
  - Carrusel de mejores calificadas  
- Buscador **Buscar** mostrando algunas peliculas y con la opcion de buscar peliculas donde al dar click en la imagen muestra **detalle**.
- Pantalla de **detalle** mostrando información y recomendaciones basadas en la película
---

## 🔗 API e Imágenes

La aplicación usa [TMDB API](https://api.themoviedb.org/3)

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

Diseño basado en [Adobe XD mockup](https://xd.adobe.com/view/feafd6f3-3f73-47c1-99d8-f7f11e5f7ac9-abfc/)

---

## 📸 App funcional 

https://github.com/user-attachments/assets/530a7ecd-802a-4883-8b2b-b65be6da2a7a

## Prueba la App

La Aplicación está disponible a través de [Appetize](https://appetize.io/app/b_soc3mpcqva2jnt4lx4ypyo3y5i)
