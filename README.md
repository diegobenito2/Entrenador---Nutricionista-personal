# VitalPro – Flujo, Wireframe y Arquitectura Técnica

> Versión inicial para iterar. Incluye mapa de navegación, wireframes mejorados, arquitectura (backend + IA), esquemas de datos y endpoints.

---

## 1) Mapa de navegación (flujo completo)

**Leyenda**: (P) Pantalla, [D] Diálogo / modal, {A} Acción, -> navegación.

1. **Welcome (P)**
   - {A} "Comenzar" -> **Login/Registro**
   - {A} "Ver demo" -> **Home (demo)**

2. **Login/Registro (P)**
   - Inputs: email/usuario, password
   - {A} OAuth (G, A, Apple)
   - {A} "¿Olvidaste tu contraseña?" -> [D] **Reset Password**
   - {A} "Crear cuenta" -> **Onboarding**

3. **Onboarding (P)**
   - Pasos: Datos básicos (edad, peso, altura, sexo), objetivo (pérdida/mantenimiento/ganancia), nivel actividad, restricciones/alergias
   - {A} Guardar -> **Home**

4. **Home/Dashboard (P)**
   - Header: saludo + fecha
   - Cards:
     - **Calendario de entrenamientos** (mini)
     - **Macros restantes** (anillo progreso + kcal y C/P/G restantes)
     - **Últimas comidas** (3 ítems)
   - FAB: **Escanear comida (IA)** -> **Scanner IA**
   - Bottom nav tabs: *Home*, *Entrenos*, *Nutrición*, *Chat*, *Perfil*

5. **Entrenos (P)**
   - **Calendario** mensual/semanal
   - Lista de sesiones del día
   - {A} Ver detalle -> **Detalle de entrenamiento**
   - {A} Cambiar a vista plan -> **Plan de entrenamiento**

6. **Detalle de entrenamiento (P)**
   - Nombre, fase, ejercicios (series x repes x carga/tiempo)
   - {A} Marcar completado
   - {A} Registrar RPE/Notas
   - {A} Adjuntar vídeo

7. **Plan de entrenamiento (P)**
   - Semanas, volumen, enfoque (fuerza, cardio, HIIT, disciplina específica)
   - {A} Solicitar ajuste -> **Chat Entrenador**

8. **Nutrición (P)**
   - Resumen: objetivo diario (kcal, C/P/G), consumido, restante
   - **Historial de comidas** por día
   - {A} **Añadir comida** -> **Scanner IA** o **Entrada manual**
   - {A} Ver receta/plantillas -> **Plantillas de comidas**

9. **Scanner IA (P)**
   - UI de captura / subir foto
   - Resultado: plato detectado, porciones, macros estimadas, confianza
   - {A} Ajustar porción manualmente
   - {A} Guardar -> actualiza **Nutrición**/**Home**

10. **Chat (P)**
   - Tabs: **Entrenador** | **Nutricionista**
   - Lista de mensajes, envío de texto, fotos, documentos
   - Atajos: "Actualizar macros", "Enviar vídeo técnica", "Revisión plan"

11. **Perfil (P)**
   - Datos personales, métricas corporales, preferencias
   - {A} Conectar wearables (Strava, Garmin, HealthKit, Google Fit)
   - {A} Cerrar sesión

12. **Admin (roles entrenador/nutricionista) (P)**
   - **Panel Clientes**: buscar, filtrar, abrir ficha
   - **Ficha Cliente**: progreso, adherencia, mensajes, cambios de plan

---

## 2) Wireframes mejorados (contenido por pantalla)

> Nota: Contenido clave y componentes; deja libertad visual para UI fina.

### Welcome
- Logo + tagline.
- Botón primario consistente (mismo color que CTA global).
- Enlace pequeño a "Política de privacidad".

### Login/Registro
- Form + OAuth.
- Feedback de errores inline.
- Botón de ojo para ver contraseña.

### Home/Dashboard
- **Widget 1 – Progreso diario**: anillo (kcal) + barras mini para C/P/G.
- **Widget 2 – Calendario**: próxima sesión + chip estado (hoy: piernas, 18:00).
- **Widget 3 – Hidratación** (opcional): vasos/objetivo.
- **Widget 4 – Últimas comidas**: miniatura foto + kcal.
- FAB flotante arriba-derecha (respetando Scaffold): **Switch tema** (como pediste) + **botón escáner**.

### Entrenos
- Calendario semanal sticky.
- Cards por sesión: icono disciplina, duración, kcal estimadas.
- Filtro: tipo (fuerza/cardio), intensidad, disciplina.

### Detalle de entrenamiento
- Lista de ejercicios con controles rápidos (+/- repeticiones/peso).
- Temporizador/cronómetro.
- Botón "Marcar completado" -> registra métrica + calcula gasto calórico.

### Nutrición
- Cabecera: Objetivo diario calculado por TDEE (editable por profesional).
- Cards de comidas (desayuno, comida, cena, snacks).
- Botón "Escanear comida" visible.
- Gráfico simple (línea o barras) última semana.

### Scanner IA
- Vista cámara + galería.
- Resultado con chips de confianza (alta/media/baja).
- Controles: deslizador porción, selector ingredientes.
- Botón "Guardar" (CTA primario).

### Chat
- Burbujas claras, timestamps, estado leído.
- Adjuntos: foto, vídeo, PDF.
- Acciones rápidas arriba (chips): “Revisar macros”, “Modificar plan”.

### Perfil
- Métricas (peso, %grasa, perímetros) con histórico.
- Conexiones con wearables.
- Preferencias: unidades, recordatorios, tema.

### Panel profesional (web o app tablet)
- Tabla clientes con KPI: adherencia entrenos, adherencia nutrición, cambios peso.
- Filtros avanzados, exportaciones.

---

## 3) Arquitectura técnica

### 3.1 Stack sugerido
- **App**: Android (Jetpack Compose, Kotlin). iOS con Kotlin Multiplatform si lo deseas.
- **Estado**: Compose + `rememberSaveable`/`SnapshotState` + repos sin ViewModel (según tu preferencia), o `ViewModel` si buscas escalabilidad.
- **Backend**: Spring Boot (Java/Kotlin) + **PostgreSQL**.
- **Autenticación**: JWT (Access + Refresh). OAuth opcional.
- **Almacenamiento**: S3 compatible (minio) para fotos de comidas.
- **Realtime**: WebSocket/STOMP para chat y eventos de progreso.
- **Jobs**: Quartz/Spring Scheduling para cierres diarios de macros.

### 3.2 Módulos backend
- `auth-service` (JWT, OAuth)
- `user-service` (perfil, métricas)
- `training-service` (planes, sesiones, registros)
- `nutrition-service` (alimentos, comidas, objetivos, macros)
- `media-service` (uploads, CDN)
- `chat-service` (threads, mensajes)
- `ai-service` (inferencia/comunicación con modelo)

---

## 4) Esquema de datos (relacional)

**users**(id, email, username, hash, role[USER|TRAINER|NUTRITIONIST|ADMIN], created_at)

**user_profile**(user_id FK, edad, peso, altura, sexo[H|M], actividad_base, objetivo[cut|maintain|bulk])

**nutrition_targets**(user_id FK, fecha, kcal, carbs_g, protein_g, fat_g, fibra_g)

**meals**(id, user_id FK, fecha_hora, nombre, foto_url, origen[IA|MANUAL], confianza)

**meal_items**(id, meal_id FK, alimento_id FK NULLABLE, nombre_libre, porcion_g, kcal, carbs_g, protein_g, fat_g)

**foods**(id, nombre, porcion_ref_g, kcal, carbs_g, protein_g, fat_g)

**workout_plans**(id, user_id FK, nombre, semana_inicio, semanas)

**workouts**(id, plan_id FK, fecha, tipo, disciplina, kcal_estimadas)

**exercises**(id, workout_id FK, nombre, series, repes, carga, tiempo_seg)

**workout_logs**(id, workout_id FK, completado, rpe, notas, kcal_reales)

**chat_threads**(id, tipo[TRAINER|NUTRITIONIST], user_id, pro_id)

**chat_messages**(id, thread_id FK, sender_id, texto, media_url, created_at)

**wearable_links**(id, user_id, proveedor, token)

Índices por (user_id, fecha) en tablas diarias para consultas rápidas.

---

## 5) Cálculo de macros y lógica

### 5.1 TDEE/Objetivo diario
1. Calcula BMR (Mifflin-St Jeor).
2. Multiplica por factor de actividad (del perfil + entrenos planificados del día).
3. Aplica objetivo (déficit/superávit) definido por profesional.
4. Deriva distribución C/P/G (ej. 45/30/25 o personalizada).

### 5.2 Pipeline IA (foto -> macros)
1. **Upload** a `/media/upload` -> URL temporal.
2. **Inferencia** en `ai-service`:
   - Modelo visión: detección multi-objeto (ej. EfficientDet/YOLO) para ingredientes/platos.
   - Clasificador de plato -> mapea a `foods` con valores base.
   - **Estimación porción**: heurística de escala (tamaño plato/mano), bounding boxes y distancia focal conocida.
   - Devuelve `{items:[{nombre, porcion_g, kcal, C/P/G, confianza}]}`.
3. **Revisión usuario** en **Scanner IA** (ajuste porción y extras).
4. **Persistencia**: crear `meals` y `meal_items`.
5. **Re-cálculo** de **restantes**: `targets - sum(meal_items del día)`.

Fallback: si confianza < umbral -> sugerir entrada manual guiada + búsqueda en base de datos.

---

## 6) API (borrador OpenAPI)

### Auth
- `POST /auth/register`
- `POST /auth/login` -> {access, refresh}
- `POST /auth/refresh`

### Usuario
- `GET /users/me`
- `PUT /users/me/profile`
- `GET /users/me/targets?fecha=YYYY-MM-DD`
- `PUT /users/me/targets` (solo profesional)

### Media/IA
- `POST /media/upload` (multipart) -> {url}
- `POST /ai/food/analyze` {imageUrl} -> {items[], confianza_global}

### Nutrición
- `GET /nutrition/meals?fecha=` -> lista
- `POST /nutrition/meals` {fecha_hora, nombre, foto_url, items[]}
- `DELETE /nutrition/meals/{id}`
- `GET /nutrition/summary?desde&hasta` -> series por día (kcal/C/P/G)

### Entrenamientos
- `GET /training/calendar?mes=`
- `GET /training/workouts/{id}`
- `POST /training/workouts/{id}/log` {completado, rpe, notas, kcal_reales}
- `GET /training/plans/current`

### Chat (REST + WS)
- `GET /chat/threads`
- `POST /chat/threads` (crear con entrenador/nutricionista)
- `GET /chat/threads/{id}/messages`
- **WS** `/ws/chat` (SUB: `/topic/thread.{id}`, SEND: `/app/thread.{id}`)

Códigos de error estandarizados: `ERR_AUTH_*`, `ERR_VALIDATION_*`, `ERR_AI_*`.

---

## 7) Seguridad y permisos
- JWT con scopes: `read:meals`, `write:meals`, `read:workouts`, etc.
- RBAC: **USER** (cliente), **TRAINER**, **NUTRITIONIST**, **ADMIN**.
- Registros profesionales solo editables por su rol.
- Firma de URLs de media y expiración corta.

---

## 8) Navegación tipada en Compose (sin strings)

```kotlin
sealed interface Route {
    @kotlinx.serialization.Serializable
data object Home: Route
    @kotlinx.serialization.Serializable
data object Workouts: Route
    @kotlinx.serialization.Serializable
data object Nutrition: Route
    @kotlinx.serialization.Serializable
data class WorkoutDetail(val id: Long): Route
    @kotlinx.serialization.Serializable
data object Chat: Route
    @kotlinx.serialization.Serializable
data object Profile: Route
}
```

Uso: `navController.navigate(WorkoutDetail(id = 42))` con un `NavType` custom serializando a JSON.

---

## 9) Repos y casos de uso (Compose sin ViewModel)

- **Repos**: `UserRepo`, `TrainingRepo`, `NutritionRepo`, `ChatRepo`, `MediaRepo`, `AiRepo`.
- **State holders** (por pantalla) con `remember` + `produceState` para efectos de carga.
- Un **ThemeController** global en un `CompositionLocal` para el **switch** de tema dentro del FAB y efecto en toda la app.

---

## 10) Algoritmo ejemplo (actualización de macros)

```kotlin
suspend fun onMealSaved(userId: Long, meal: Meal) {
    nutritionApi.saveMeal(meal)
    val today = LocalDate.now()
    val target = nutritionApi.getTargets(date = today)
    val consumed = nutritionApi.getMeals(date = today).sumMacros()
    val remaining = target - consumed
    dashboardState.update { it.copy(macrosRemaining = remaining) }
}
```

---

## 11) Métricas y analítica
- Adherencia entrenamiento (% sesiones completadas/planificadas)
- Adherencia nutrición (% días dentro de ±10% objetivo kcal y ±15% macro)
- Tiempo de respuesta del profesional en chat

---

## 12) Roadmap sugerido
1. **MVP**: Auth, Home, Nutrición (manual), Entrenos básicos, Chat, Targets.
2. **IA v1**: Clasificación plato + porción manual.
3. **IA v2**: Estimación porción semiautomática + confianza.
4. **Integraciones**: wearables, notificaciones push.
5. **Panel Pro**: web para entrenadores/nutricionistas.

---

## 13) Diseño/UX – sistema de color
- Primario único (ej. morado) para CTA + enlaces activos.
- Secundario complementario (verde) solo para estados "positivo".
- Tipografía: Sans moderna, pesos 400/600.
- Esquinas 2xl, sombras suaves, grid 8pt.

---

### ¿Siguiente paso?
- Puedo generar **componentes Compose** base (Dashboard, Calendario, Scanner IA stub), o un **OpenAPI.yaml** listo para importar en Postman/Swagger. Indica qué prefieres y lo añado.

