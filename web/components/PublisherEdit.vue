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
            v-model="name"
            :rules="nameRules"
            label="Publisher's Name"
            required
          />
          <br>
          <v-row justify="end">
            <v-btn
              color="primary"
              @click="update()"
            >
              Save
            </v-btn>
          </v-row>
        </v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  props: {
    publisherName: {
      type: String,
      default: ''
    }
  },
  data () {
    return {
      name: JSON.parse(this.publisherName),
      nameRules: [
        v => !v || /^(?=.{1,})/.test(v) || 'Publisher\'s name must contains at least 1 character.'
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
