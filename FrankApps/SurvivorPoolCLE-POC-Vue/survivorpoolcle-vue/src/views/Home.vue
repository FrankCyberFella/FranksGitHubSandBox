<template>
  <div class="home">
    <img alt="Survivor logo" src="../assets/Survivor David-Goliath-38.jpg" />
    <Players msg="Welcome to Survivor Pool CLE" />
  </div>
</template>

<script>
// @ is an alias to /src
import Players from "@/components/Players.vue";

export default {
  name: "home",
  components: {
    Players
  }
};
</script>
