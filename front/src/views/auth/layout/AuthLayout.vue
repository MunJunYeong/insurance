<template>
    <v-container>
        <br>
        <v-row justify="center">
          <v-col cols='4'>
            <div style="text-align: center;" v-on:click="goHome"> <h2 style="display : inline">신동아화재</h2>&nbsp;&nbsp;&nbsp;보험회사</div>
          </v-col>
        </v-row>
        <br>
        <router-view />
  </v-container>

</template>
<script>
export default {
  components: {
  },
  data: () => ({
    //
  }),
  methods : {
      goHome(){
        location.href='#/home'
      }
    }
};

</script>