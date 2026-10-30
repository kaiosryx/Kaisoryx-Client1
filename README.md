# Kaisoryx Client — Fabric source project

A client-side Minecraft Java mod project for **1.21.11**, Java 21 and Fabric.

## Current prototype
- Right Shift opens a futuristic click-GUI.
- GUI module rows can be toggled and the list can be scrolled.
- V toggles a basic forward sprint helper.
- Module registry includes planned HUD, cosmetics and visual/performance options.

## Important status
This is an **early source prototype**, not a finished feature-complete client and not a compiled JAR. Several listed modules are registry/UI entries only; FPS/coordinates/keystrokes rendering, zoom, CPS, armor HUD, persistent profiles, and real graphics-setting integration still need implementation and testing. No FPS increase is guaranteed: performance depends on hardware, drivers, shaders, resource packs, and world/server load.

## Build
1. Install a JDK 21 distribution.
2. Install Gradle 8.14+ (or use your IDE's Gradle integration).
3. Run `gradle build`.
4. The remapped mod JAR will be in `build/libs/`.
5. Install Fabric Loader for Minecraft 1.21.11 and a matching Fabric API, then put the JAR in `.minecraft/mods`.

## Default keys
- Right Shift: open Click GUI
- V: toggle sprint helper
- C: reserved for zoom (not implemented in this prototype)

## Fair-play and cosmetics
The project is intended for client-side quality-of-life, HUD, accessibility, visual customization and performance controls. It does not include combat automation, reach modification, kill aura, or other unfair multiplayer features. Cosmetic effects are local-only unless a server explicitly supports a cosmetic system.

## Version note
Dependency versions are pinned in `gradle.properties`; confirm the current Fabric Loader/API and mappings compatibility before release. This project has not been built or runtime-tested in this environment.
