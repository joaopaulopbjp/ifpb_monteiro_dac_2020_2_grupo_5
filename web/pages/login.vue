<template>
  <v-row justify="center">
    <v-col
      cols="12"
      sm="10"
      md="8"
      lg="6"
    >
      <v-card class="v-card-container">
        <v-card-text>
          <v-text-field
            v-model="email"
            :rules="emailRules"
            label="E-mail"
            required
          />
          <v-text-field
            v-model="password"
            :rules="passwordRules"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            :type="showPassword ? 'text' : 'password'"
            label="Password"
            required
            @click:append="showPassword = !showPassword"
          />
          Don't have an account?
          <router-link
            to="/signup"
          >
            Sign Up
          </router-link>
          <br>
          <v-row justify="end">
            <v-btn
              to="/"
              color="primary"
            >
              Login
            </v-btn>
          </v-row>
        </v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data () {
    return {
      email: '',
      password: '',
      showPassword: false,
      emailRules: [
        v => !v || /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail must be valid'
      ],
      passwordRules: [
        v => !v || /^(?=.*[a-z])/.test(v) || 'Password must contains at least one lowercase character.',
        v => !v || /^(?=.*[A-Z])/.test(v) || 'Password must contains at least one capital letter.',
        v => !v || /^(?=.*[0-9])/.test(v) || 'Password must contains at least one number.',
        v => !v || /^(?=.*[!@#$%^&*])/.test(v) || 'Password must contains at least one special character.',
        v => !v || /^(?=.{8,})/.test(v) || 'Password must contains at least 8 characters.'
      ]
    }
  }
}
</script>
<style scoped>
  .v-card-container{
    padding: 10px;
  }
</style>
