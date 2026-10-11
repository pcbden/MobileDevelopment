# Lab 8 & Practice 5 - Android App (Jetpack Compose)

Bu loyiha Jetpack Compose va Material 3 da yozilgan o'quv laboratoriya ishi hisoblanadi.

## Nimalar qilingan:
- **Part A:** remember va rememberSaveable orqali stateni saqlash va state hoisting.
- **Part B:** ViewModel va Sealed Interface yordamida yozilgan Sign-In (Kirish) ekrani.
- **Part C:** Artistlarni tanlash uchun Taste Picker ekran va grid qismi, hamda Unit testlar.
- **Practice 5:** Compose Modifier va Material 3 savollarining javoblari (Q1-Q42).

---

# Practice 5 — Savol va Javoblar (Q1 – Q42)

### Part A — Compose Modifier Asoslari (Q1–15)
- **Q1:** `Column` ga qanday padding beriladi? -> `Modifier.padding(16.dp)`
- **Q2:** Elementni butun ekranga egallash? -> `Modifier.fillMaxSize()`
- **Q3:** Element o'lchamini belgilash? -> `Modifier.size(48.dp)`
- **Q4:** Doira shaklida qirqish (clip)? -> `Modifier.clip(CircleShape)`
- **Q5:** Fon rangini berish? -> `Modifier.background(Color.Red)`
- **Q6:** Ramka (Border) chizish? -> `Modifier.border(2.dp, Color.Black, CircleShape)`
- **Q7:** Bosinganini (Click) ushlash? -> `Modifier.clickable { onClick() }`
- **Q8:** Row ichida nisbatan kenglik berish? -> `RowScope` ichida `Modifier.weight(1f)`
- **Q9:** Ustun va satrda markazlashtirish? -> `Alignment.CenterHorizontally` / `Arrangement.Center`
- **Q10:** Proportsional joy ajratish? -> `Row` da child-larga `.weight(2f)` va `.weight(1f)` berish.
- **Q11:** Box ichidagi rasmni markazga qo'yish? -> `Box(contentAlignment = Alignment.Center)` va `Modifier.align(Alignment.Center)`.
- **Q12:** Qayta ishlatiluvchi composable-da Modifier idiomalari? -> `modifier` parametrini birinchi bo'lib ildiz composable-ga berish.
- **Q13:** Text-ni natural hajmini saqlab markazga qo'yish? -> `Modifier.fillMaxSize().wrapContentSize(Alignment.Center)`
- **Q14:** 16:9 proporsiyada rasmni avto-cho'zish? -> `Modifier.fillMaxWidth().aspectRatio(16f / 9f)`
- **Q15:** Doiraviy Avatar Modifier ketma-ketligi? -> `Modifier.size(56.dp).border(...).padding(...).clip(...).background(...)`

### Part B — Advanced Modifier Amaliyoti (Q16–30)
- **Q16:** Settings ekrani kirmay qobti scrol qilish kerek. -> `Modifier.verticalScroll(rememberScrollState())` ishlatiladi. State objekti: `ScrollState`.
- **Q17:** Filter chip lari ekrandan chiqib keti yonga scroll kerek. -> `Modifier.horizontalScroll(rememberScrollState())` beramiz.
- **Q18:** QA button textiga qarame topishi kerek testda id bering. -> `Modifier.testTag("submit_button")` va `onNodeWithTag("submit_button")`.
- **Q19:** Chizik divider va Warning ikonka accessibility farqi nima? -> Chizik oddiy bezak (`contentDescription = null`), Warning muhim (`contentDescription = "Warning"`).
- **Q20:** Card fade animatsiyasini recomposition qilmasdan graphicsLayer bilan yozing. -> `Modifier.graphicsLayer { alpha = animatedAlpha }`. Lambda drawing fazasida o'qiladi.
- **Q21:** Rotate va scale birga graphicsLayer da yozing. -> `Modifier.graphicsLayer { rotationZ = angle; scaleX = scale; scaleY = scale }`.
- **Q22:** Birinchi card ikkinchisini ustida korinsin drag bolganda. -> `Modifier.zIndex(if (isBeingDragged) 1f else 0f)`.
- **Q23:** `dashedBorder` funksiyasi va u `@Composable` bolishi kereymi? -> `@Composable` shartmas, chunki compose state o'qimaydi.
- **Q24:** Map marker pin tap va long-press ikkalasini ushlash. -> `Modifier.combinedClickable(onClick = { ... }, onLongClick = { ... })`.
- **Q25:** `size(100.dp)` vs `requiredSize(100.dp)` farqi nima 60dp papkada? -> `requiredSize` cheklovni inkor qilib 100dp qiladi, `size` esa 60dp ga cheklanadi.
- **Q26:** Chat LazyColumn va birinchi/oxirgi padding xatosi. -> `contentPadding = PaddingValues(16.dp)` ishlatiladi, viewport kichraymaydi.
- **Q27:** Avatar orqasidagi glow Box rasmni razmeriga mos bolsin. -> `Modifier.matchParentSize()` (BoxScope ichida).
- **Q28:** `fun myRow()` ichida `.weight(1f)` xatosi va yechimi. -> `RowScope` kengaytmasi qilish kerek (`fun RowScope.myRow()`).
- **Q29:** Tabletda search bar 80% enida ortada tursin. -> `Modifier.fillMaxWidth(0.8f).wrapContentWidth(Alignment.CenterHorizontally)`.
- **Q30:** `background` dan kiyin `clip` qoyganda burchak chetlanmadi nega? -> `.clip()` oldin kelishi kerak yoki `.background(color, shape)` beriladi.

### Part C — Material 3 va Responsive Layout (Q31–42)
- **Q31:** Material Design nega oddiy skin emas? -> Bu rang, shrift, shakl, harakat va balandlikdan iborat tizim. Accessibility va platforma mosligini bepul beradi.
- **Q32:** Dynamic Color nima va qaysi API kerek? -> Fon rasmidan rang oladi. Android 12 (API 31) talab qiladi.
- **Q33:** Material 2 va Material 3 ranglar farqi? -> M2 da 8 ta static rang bor edi, M3 da seed rangdan Tonal role tizimi avtomatik yaratiladi.
- **Q34:** Snackbar va Card shakllari nega ozgard? -> M2 da 3 ta shape bor edi, M3 da 7 ta shape toifasi mavjud.
- **Q35:** `AppTheme` dagi SDK check nega kerak? -> API 31 dan pastda `dynamicLightColorScheme` crash beradi.
- **Q36:** Save, Preview, Cancel button lar tanlovi? -> Save (`Button`), Preview (`FilledTonalButton`), Cancel (`OutlinedButton`). Ekranda bitta asosiy filled button bo'ladi.
- **Q37:** WindowSizeClass 3 ta breakpoint. -> Compact (<600dp), Medium (600-839dp), Expanded (>=840dp).
- **Q38:** Adaptiv nav bar when kodi. -> `when(windowSizeClass.widthSizeClass) { Compact -> BottomBar(), Medium -> NavRail(), Expanded -> Drawer() }`
- **Q39:** Manual dp va bir marta startupda check qilish xatosi? -> Qo'lda dp taqqoslash eskirgan, startup check esa ekranni o'lchami o'zgarganda (foldable) ishlamaydi.
- **Q40:** `textView.text = "$count"` nega Compose da xato? -> Views imperativ edi, Compose esa deklarativ (`Text("$count")`).
- **Q41:** `remember` siz mutableStateOf va recomposition? -> `remember` state-ni saqlaydi. Recomposition o'zgargan stateni o'quvchi qismlarni qayta chizadi.
- **Q42:** Counter ni state hoisting qilish kodi va foydasi? -> State yuqoriga chiqariladi, komponent stateless bo'lib qayta ishlatish va testlash osonlashadi.
