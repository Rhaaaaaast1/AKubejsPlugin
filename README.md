# AKubejsPlugin

Standalone KubeJS toolkit for NeoForge 1.21.1. It does **not** require Tinkers'
Construct or Create; those are optional integrations.

## Features

### Core (always available with KubeJS)

- `ItemStackAPI` — read/write/merge/remove `minecraft:custom_data`, copy components.
- `ServerEvents.recipeOutput` — rewrite outputs for vanilla shaped/shapeless/cooking/
  stonecutting/smithing recipes.
- `BlockEvents.blockEntitySlotChanged` — observe container slot changes.
- `BlockEntityAPI` — wrap `Container`, `WorldlyContainer`, or `IItemHandler`.
- `PlayerEvents.rightClickBlockPre` — cancellable right-click interception.

### Optional Tinkers' Construct integration

Loaded only when `tconstruct` is present. Controlled by
`AKubejsPluginMixinPlugin`; the mixin config is skipped entirely otherwise.

- `MaterialCastingRecipe#assemble` hook: replaces the real cast part with an
  unfinished item, copying `Material` into `minecraft:custom_data`.
- Mantle `setChangedFast` hook: lets `blockEntitySlotChanged` see casting table
  output for fallback logic.
- Mapping config: `config/akubejsplugin-unfinished-parts.json`
  (see `examples/akubejsplugin-unfinished-parts.json`).

Default mapping is `tconstruct:<part> -> kubejs:unfinished_<part>`.

### Optional Create

This mod contains no Create code. Create sequenced assembly recipes can be
generated from KubeJS scripts or datapacks; the casting hook only produces the
unfinished item.

## Build

The Gradle wrapper uses the Tencent mirror:

```text
https://mirrors.cloud.tencent.com/gradle/gradle-8.8-bin.zip
```

```powershell
$env:JAVA_HOME='E:\JDK\jdk21'
.\gradlew.bat build
```

`libs/` must contain `Mantle-1.21.1-1.13.1.jar` and
`TinkersConstruct-1.21.1-3.13.3.jar` for the optional compile-time integration.

## Notes

- Experimental/incubating Gradle warnings are disabled in `gradle.properties`
  (`org.gradle.warning.mode=none`, `org.gradle.configuration-cache=false`).
- Without KubeJS the mod loads but registers no KubeJS plugin/bindings.
- Without Tinkers' Construct the optional mixin config is skipped.
