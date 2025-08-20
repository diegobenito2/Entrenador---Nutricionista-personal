<<<<<<< Updated upstream
# Entrenador---Nutricionista-personal
Aplicación gestión nutritiva y entrenamiento personal planificado.
# Configuración
  1. Perfil con la información personal del usuario y opción de editar usuario.
  2. Si no está iniciada la sesión inicio de sesión.
  3. Cambio de configuración Personalización(modo oscuro), Privacidad y Seguridad(Cambio de contraseña, 2FA).
  4. Cierre de sesión.
## **Pantalla Inicial**
  1. Dashboard
     <img width="1747" height="1005" alt="image" src="https://github.com/user-attachments/assets/9b1fc551-ed65-4c72-b45c-def10283e184" />
  2. Proxima Cómida
  3. Macros restantes/Completos.
     
## **Pantalla Entrenador personal**
  1. Chat con la IA para tener una idea de lo que hace, nivel que quiere llegar y tiempo de entrenamiento.
  2. Acceso al calendario para la sincronización y planificación de ello.
  3. Equipo con el que se dispone.(Zapatillas de correr, Bici de carretera,etc)
     
## **Pantalla Nutricionismo**
  1. Preguntas para la definición de que fisico se quiere conseguir y que alimentación le gusta.
  2. Enviar una imagen a la IA y que marque los macros que tiene esa comida de la imagen.
  3. Proxima comida o si no hay proxima comida planificada crear recetas de ejemplo para cumplir con los macros proporcionados.

=======
# º# VitalPro – Flujo, Wireframe y Arquitectura Técnica

# 

# > Versión inicial para iterar. Incluye mapa de navegación, wireframes mejorados, arquitectura (backend + IA), esquemas de datos y endpoints.

# 

# ---

# 

# \## 1) Mapa de navegación (flujo completo)

# 

# \*\*Leyenda\*\*: (P) Pantalla, \[D] Diálogo / modal, {A} Acción, -> navegación.

# 

# 1\. \*\*Welcome (P)\*\*

# &nbsp;  - {A} "Comenzar" -> \*\*Login/Registro\*\*

# &nbsp;  - {A} "Ver demo" -> \*\*Home (demo)\*\*

# 

# 2\. \*\*Login/Registro (P)\*\*

# &nbsp;  - Inputs: email/usuario, password

# &nbsp;  - {A} OAuth (G, A, Apple)

# &nbsp;  - {A} "¿Olvidaste tu contraseña?" -> \[D] \*\*Reset Password\*\*

# &nbsp;  - {A} "Crear cuenta" -> \*\*Onboarding\*\*

# 

# 3\. \*\*Onboarding (P)\*\*

# &nbsp;  - Pasos: Datos básicos (edad, peso, altura, sexo), objetivo (pérdida/mantenimiento/ganancia), nivel actividad, restricciones/alergias

# &nbsp;  - {A} Guardar -> \*\*Home\*\*

# 

# 4\. \*\*Home/Dashboard (P)\*\*

# &nbsp;  - Header: saludo + fecha

# &nbsp;  - Cards:

# &nbsp;    - \*\*Calendario de entrenamientos\*\* (mini)

# &nbsp;    - \*\*Macros restantes\*\* (anillo progreso + kcal y C/P/G restantes)

# &nbsp;    - \*\*Últimas comidas\*\* (3 ítems)

# &nbsp;  - FAB: \*\*Escanear comida (IA)\*\* -> \*\*Scanner IA\*\*

# &nbsp;  - Bottom nav tabs: \*Home\*, \*Entrenos\*, \*Nutrición\*, \*Chat\*, \*Perfil\*

# 

# 5\. \*\*Entrenos (P)\*\*

# &nbsp;  - \*\*Calendario\*\* mensual/semanal

# &nbsp;  - Lista de sesiones del día

# &nbsp;  - {A} Ver detalle -> \*\*Detalle de entrenamiento\*\*

# &nbsp;  - {A} Cambiar a vista plan -> \*\*Plan de entrenamiento\*\*

# 

# 6\. \*\*Detalle de entrenamiento (P)\*\*

# &nbsp;  - Nombre, fase, ejercicios (series x repes x carga/tiempo)

# &nbsp;  - {A} Marcar completado

# &nbsp;  - {A} Registrar RPE/Notas

# &nbsp;  - {A} Adjuntar vídeo

# 

# 7\. \*\*Plan de entrenamiento (P)\*\*

# &nbsp;  - Semanas, volumen, enfoque (fuerza, cardio, HIIT, disciplina específica)

# &nbsp;  - {A} Solicitar ajuste -> \*\*Chat Entrenador\*\*

# 

# 8\. \*\*Nutrición (P)\*\*

# &nbsp;  - Resumen: objetivo diario (kcal, C/P/G), consumido, restante

# &nbsp;  - \*\*Historial de comidas\*\* por día

# &nbsp;  - {A} \*\*Añadir comida\*\* -> \*\*Scanner IA\*\* o \*\*Entrada manual\*\*

# &nbsp;  - {A} Ver receta/plantillas -> \*\*Plantillas de comidas\*\*

# 

# 9\. \*\*Scanner IA (P)\*\*

# &nbsp;  - UI de captura / subir foto

# &nbsp;  - Resultado: plato detectado, porciones, macros estimadas, confianza

# &nbsp;  - {A} Ajustar porción manualmente

# &nbsp;  - {A} Guardar -> actualiza \*\*Nutrición\*\*/\*\*Home\*\*

# 

# 10\. \*\*Chat (P)\*\*

# &nbsp;  - Tabs: \*\*Entrenador\*\* | \*\*Nutricionista\*\*

# &nbsp;  - Lista de mensajes, envío de texto, fotos, documentos

# &nbsp;  - Atajos: "Actualizar macros", "Enviar vídeo técnica", "Revisión plan"

# 

# 11\. \*\*Perfil (P)\*\*

# &nbsp;  - Datos personales, métricas corporales, preferencias

# &nbsp;  - {A} Conectar wearables (Strava, Garmin, HealthKit, Google Fit)

# &nbsp;  - {A} Cerrar sesión

# 

# 12\. \*\*Admin (roles entrenador/nutricionista) (P)\*\*

# &nbsp;  - \*\*Panel Clientes\*\*: buscar, filtrar, abrir ficha

# &nbsp;  - \*\*Ficha Cliente\*\*: progreso, adherencia, mensajes, cambios de plan

# 

# ---

# 

# \## 2) Wireframes mejorados (contenido por pantalla)

# 

# > Nota: Contenido clave y componentes; deja libertad visual para UI fina.

# 

# \### Welcome

# \- Logo + tagline.

# \- Botón primario consistente (mismo color que CTA global).

# \- Enlace pequeño a "Política de privacidad".

# 

# \### Login/Registro

# \- Form + OAuth.

# \- Feedback de errores inline.

# \- Botón de ojo para ver contraseña.

# 

# \### Home/Dashboard

# \- \*\*Widget 1 – Progreso diario\*\*: anillo (kcal) + barras mini para C/P/G.

# \- \*\*Widget 2 – Calendario\*\*: próxima sesión + chip estado (hoy: piernas, 18:00).

# \- \*\*Widget 3 – Hidratación\*\* (opcional): vasos/objetivo.

# \- \*\*Widget 4 – Últimas comidas\*\*: miniatura foto + kcal.

# \- FAB flotante arriba-derecha (respetando Scaffold): \*\*Switch tema\*\* (como pediste) + \*\*botón escáner\*\*.

# 

# \### Entrenos

# \- Calendario semanal sticky.

# \- Cards por sesión: icono disciplina, duración, kcal estimadas.

# \- Filtro: tipo (fuerza/cardio), intensidad, disciplina.

# 

# \### Detalle de entrenamiento

# \- Lista de ejercicios con controles rápidos (+/- repeticiones/peso).

# \- Temporizador/cronómetro.

# \- Botón "Marcar completado" -> registra métrica + calcula gasto calórico.

# 

# \### Nutrición

# \- Cabecera: Objetivo diario calculado por TDEE (editable por profesional).

# \- Cards de comidas (desayuno, comida, cena, snacks).

# \- Botón "Escanear comida" visible.

# \- Gráfico simple (línea o barras) última semana.

# 

# \### Scanner IA

# \- Vista cámara + galería.

# \- Resultado con chips de confianza (alta/media/baja).

# \- Controles: deslizador porción, selector ingredientes.

# \- Botón "Guardar" (CTA primario).

# 

# \### Chat

# \- Burbujas claras, timestamps, estado leído.

# \- Adjuntos: foto, vídeo, PDF.

# \- Acciones rápidas arriba (chips): “Revisar macros”, “Modificar plan”.

# 

# \### Perfil

# \- Métricas (peso, %grasa, perímetros) con histórico.

# \- Conexiones con wearables.

# \- Preferencias: unidades, recordatorios, tema.

# 

# \### Panel profesional (web o app tablet)

# \- Tabla clientes con KPI: adherencia entrenos, adherencia nutrición, cambios peso.

# \- Filtros avanzados, exportaciones.

# 

# ---

# 

# \## 3) Arquitectura técnica

# 

# \### 3.1 Stack sugerido

# \- \*\*App\*\*: Android (Jetpack Compose, Kotlin). iOS con Kotlin Multiplatform si lo deseas.

# \- \*\*Estado\*\*: Compose + `rememberSaveable`/`SnapshotState` + repos sin ViewModel (según tu preferencia), o `ViewModel` si buscas escalabilidad.

# \- \*\*Backend\*\*: Spring Boot (Java/Kotlin) + \*\*PostgreSQL\*\*.

# \- \*\*Autenticación\*\*: JWT (Access + Refresh). OAuth opcional.

# \- \*\*Almacenamiento\*\*: S3 compatible (minio) para fotos de comidas.

# \- \*\*Realtime\*\*: WebSocket/STOMP para chat y eventos de progreso.

# \- \*\*Jobs\*\*: Quartz/Spring Scheduling para cierres diarios de macros.

# 

# \### 3.2 Módulos backend

# \- `auth-service` (JWT, OAuth)

# \- `user-service` (perfil, métricas)

# \- `training-service` (planes, sesiones, registros)

# \- `nutrition-service` (alimentos, comidas, objetivos, macros)

# \- `media-service` (uploads, CDN)

# \- `chat-service` (threads, mensajes)

# \- `ai-service` (inferencia/comunicación con modelo)

# 

# ---

# 

# \## 4) Esquema de datos (relacional)

# 

# \*\*users\*\*(id, email, username, hash, role\[USER|TRAINER|NUTRITIONIST|ADMIN], created\_at)

# 

# \*\*user\_profile\*\*(user\_id FK, edad, peso, altura, sexo\[H|M], actividad\_base, objetivo\[cut|maintain|bulk])

# 

# \*\*nutrition\_targets\*\*(user\_id FK, fecha, kcal, carbs\_g, protein\_g, fat\_g, fibra\_g)

# 

# \*\*meals\*\*(id, user\_id FK, fecha\_hora, nombre, foto\_url, origen\[IA|MANUAL], confianza)

# 

# \*\*meal\_items\*\*(id, meal\_id FK, alimento\_id FK NULLABLE, nombre\_libre, porcion\_g, kcal, carbs\_g, protein\_g, fat\_g)

# 

# \*\*foods\*\*(id, nombre, porcion\_ref\_g, kcal, carbs\_g, protein\_g, fat\_g)

# 

# \*\*workout\_plans\*\*(id, user\_id FK, nombre, semana\_inicio, semanas)

# 

# \*\*workouts\*\*(id, plan\_id FK, fecha, tipo, disciplina, kcal\_estimadas)

# 

# \*\*exercises\*\*(id, workout\_id FK, nombre, series, repes, carga, tiempo\_seg)

# 

# \*\*workout\_logs\*\*(id, workout\_id FK, completado, rpe, notas, kcal\_reales)

# 

# \*\*chat\_threads\*\*(id, tipo\[TRAINER|NUTRITIONIST], user\_id, pro\_id)

# 

# \*\*chat\_messages\*\*(id, thread\_id FK, sender\_id, texto, media\_url, created\_at)

# 

# \*\*wearable\_links\*\*(id, user\_id, proveedor, token)

# 

# Índices por (user\_id, fecha) en tablas diarias para consultas rápidas.

# 

# ---

# 

# \## 5) Cálculo de macros y lógica

# 

# \### 5.1 TDEE/Objetivo diario

# 1\. Calcula BMR (Mifflin-St Jeor).

# 2\. Multiplica por factor de actividad (del perfil + entrenos planificados del día).

# 3\. Aplica objetivo (déficit/superávit) definido por profesional.

# 4\. Deriva distribución C/P/G (ej. 45/30/25 o personalizada).

# 

# \### 5.2 Pipeline IA (foto -> macros)

# 1\. \*\*Upload\*\* a `/media/upload` -> URL temporal.

# 2\. \*\*Inferencia\*\* en `ai-service`:

# &nbsp;  - Modelo visión: detección multi-objeto (ej. EfficientDet/YOLO) para ingredientes/platos.

# &nbsp;  - Clasificador de plato -> mapea a `foods` con valores base.

# &nbsp;  - \*\*Estimación porción\*\*: heurística de escala (tamaño plato/mano), bounding boxes y distancia focal conocida.

# &nbsp;  - Devuelve `{items:\[{nombre, porcion\_g, kcal, C/P/G, confianza}]}`.

# 3\. \*\*Revisión usuario\*\* en \*\*Scanner IA\*\* (ajuste porción y extras).

# 4\. \*\*Persistencia\*\*: crear `meals` y `meal\_items`.

# 5\. \*\*Re-cálculo\*\* de \*\*restantes\*\*: `targets - sum(meal\_items del día)`.

# 

# Fallback: si confianza < umbral -> sugerir entrada manual guiada + búsqueda en base de datos.

# 

# ---

# 

# \## 6) API (borrador OpenAPI)

# 

# \### Auth

# \- `POST /auth/register`

# \- `POST /auth/login` -> {access, refresh}

# \- `POST /auth/refresh`

# 

# \### Usuario

# \- `GET /users/me`

# \- `PUT /users/me/profile`

# \- `GET /users/me/targets?fecha=YYYY-MM-DD`

# \- `PUT /users/me/targets` (solo profesional)

# 

# \### Media/IA

# \- `POST /media/upload` (multipart) -> {url}

# \- `POST /ai/food/analyze` {imageUrl} -> {items\[], confianza\_global}

# 

# \### Nutrición

# \- `GET /nutrition/meals?fecha=` -> lista

# \- `POST /nutrition/meals` {fecha\_hora, nombre, foto\_url, items\[]}

# \- `DELETE /nutrition/meals/{id}`

# \- `GET /nutrition/summary?desde\&hasta` -> series por día (kcal/C/P/G)

# 

# \### Entrenamientos

# \- `GET /training/calendar?mes=`

# \- `GET /training/workouts/{id}`

# \- `POST /training/workouts/{id}/log` {completado, rpe, notas, kcal\_reales}

# \- `GET /training/plans/current`

# 

# \### Chat (REST + WS)

# \- `GET /chat/threads`

# \- `POST /chat/threads` (crear con entrenador/nutricionista)

# \- `GET /chat/threads/{id}/messages`

# \- \*\*WS\*\* `/ws/chat` (SUB: `/topic/thread.{id}`, SEND: `/app/thread.{id}`)

# 

# Códigos de error estandarizados: `ERR\_AUTH\_\*`, `ERR\_VALIDATION\_\*`, `ERR\_AI\_\*`.

# 

# ---

# 

# \## 7) Seguridad y permisos

# \- JWT con scopes: `read:meals`, `write:meals`, `read:workouts`, etc.

# \- RBAC: \*\*USER\*\* (cliente), \*\*TRAINER\*\*, \*\*NUTRITIONIST\*\*, \*\*ADMIN\*\*.

# \- Registros profesionales solo editables por su rol.

# \- Firma de URLs de media y expiración corta.

# 

# ---

# 

# \## 8) Navegación tipada en Compose (sin strings)

# 

# ```kotlin

# sealed interface Route {

# &nbsp;   @kotlinx.serialization.Serializable

# data object Home: Route

# &nbsp;   @kotlinx.serialization.Serializable

# data object Workouts: Route

# &nbsp;   @kotlinx.serialization.Serializable

# data object Nutrition: Route

# &nbsp;   @kotlinx.serialization.Serializable

# data class WorkoutDetail(val id: Long): Route

# &nbsp;   @kotlinx.serialization.Serializable

# data object Chat: Route

# &nbsp;   @kotlinx.serialization.Serializable

# data object Profile: Route

# }

# ```

# 

# Uso: `navController.navigate(WorkoutDetail(id = 42))` con un `NavType` custom serializando a JSON.

# 

# ---

# 

# \## 9) Repos y casos de uso (Compose sin ViewModel)

# 

# \- \*\*Repos\*\*: `UserRepo`, `TrainingRepo`, `NutritionRepo`, `ChatRepo`, `MediaRepo`, `AiRepo`.

# \- \*\*State holders\*\* (por pantalla) con `remember` + `produceState` para efectos de carga.

# \- Un \*\*ThemeController\*\* global en un `CompositionLocal` para el \*\*switch\*\* de tema dentro del FAB y efecto en toda la app.

# 

# ---

# 

# \## 10) Algoritmo ejemplo (actualización de macros)

# 

# ```kotlin

# suspend fun onMealSaved(userId: Long, meal: Meal) {

# &nbsp;   nutritionApi.saveMeal(meal)

# &nbsp;   val today = LocalDate.now()

# &nbsp;   val target = nutritionApi.getTargets(date = today)

# &nbsp;   val consumed = nutritionApi.getMeals(date = today).sumMacros()

# &nbsp;   val remaining = target - consumed

# &nbsp;   dashboardState.update { it.copy(macrosRemaining = remaining) }

# }

# ```

# 

# ---

# 

# \## 11) Métricas y analítica

# \- Adherencia entrenamiento (% sesiones completadas/planificadas)

# \- Adherencia nutrición (% días dentro de ±10% objetivo kcal y ±15% macro)

# \- Tiempo de respuesta del profesional en chat

# 

# ---

# 

# \## 12) Roadmap sugerido

# 1\. \*\*MVP\*\*: Auth, Home, Nutrición (manual), Entrenos básicos, Chat, Targets.

# 2\. \*\*IA v1\*\*: Clasificación plato + porción manual.

# 3\. \*\*IA v2\*\*: Estimación porción semiautomática + confianza.

# 4\. \*\*Integraciones\*\*: wearables, notificaciones push.

# 5\. \*\*Panel Pro\*\*: web para entrenadores/nutricionistas.

# 

# ---

# 

# \## 13) Diseño/UX – sistema de color

# \- Primario único (ej. morado) para CTA + enlaces activos.

# \- Secundario complementario (verde) solo para estados "positivo".

# \- Tipografía: Sans moderna, pesos 400/600.

# \- Esquinas 2xl, sombras suaves, grid 8pt.

# 

# ---

# 

# \### ¿Siguiente paso?

# \- Puedo generar \*\*componentes Compose\*\* base (Dashboard, Calendario, Scanner IA stub), o un \*\*OpenAPI.yaml\*\* listo para importar en Postman/Swagger. Indica qué prefieres y lo añado.

# 
>>>>>>> Stashed changes



