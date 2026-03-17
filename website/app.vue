<template>
  <div>
    <NuxtLayout>
      <NuxtPage />
    </NuxtLayout>
  </div>
</template>

<script setup lang="ts">
import '@unocss/reset/tailwind.css'

useHead({
  titleTemplate: '%s - Neocon'
})
</script>

<style>
html,
body {
  overflow-x: hidden;
}
</style>
