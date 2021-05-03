<template>
  <v-card class="v-card-container" width="300">
    <v-card-title>
      {{ title }}
    </v-card-title>
    <v-card-text>
      <v-row justify="end" class="padding" align="end">
        <v-card-subtitle>
          R${{ price }}
        </v-card-subtitle>
        <v-btn
          to="/cart"
          color="primary"
        >
          Add do cart
        </v-btn>
      </v-row>
    </v-card-text>
  </v-card>
</template>
<script>
export default {
  props: {
    title: {
      type: String,
      default: ''
    },
    price: {
      type: Number,
      default: 0.0
    }
  }
}
</script>
<style scoped>
  .padding{
    padding: 5px;
  }
  .v-card__subtitle{
    padding: 10px 70px 10px 0px;
    font-size: 18px;
  }
</style>
