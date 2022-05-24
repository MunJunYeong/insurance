<template>
    <v-app-bar app="app" color="#CFD8DC">
        <v-col cols="3">
            보험회사
        </v-col>
        <v-col cols="6">
            상단 네비게이션
        </v-col>
        <v-col cols='3'>
            <router-link to="/auth/signin"   >
                <v-btn elevation="2" class="btn_loginEnter" outlined="outlined" rounded="rounded">로그인</v-btn>
            </router-link>
            <router-link to="/auth/signup"  >
                <v-btn elevation="2" class="btn_loginEnter" outlined="outlined" rounded="rounded">회원가입</v-btn>
            </router-link>
        </v-col>

    </v-app-bar>

</template>

<script>

    export default {
        name: 'HeaderNav',
        props: {
            
        },
        created(){
            
        },
        data(){
            return{
                
            }
        },
        computed: {
            
        },
        methods : {

        }

    }
</script>
<style scoped>
    #loginWelcome{
        font-weight: 400; font-size: 1.5em; color: black;
    }
    #showRole{
        font-size: 0.6em; display: inline; color: darkgreen;
    }
    
</style>