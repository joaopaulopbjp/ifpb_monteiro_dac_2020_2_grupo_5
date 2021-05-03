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
          {{ bookTitle }}
          <br>
          Stock: {{ bookStock }}
          <br>
          Price: {{ bookPrice }}
          <br>
          <v-row justify="end">
            <v-btn
              color="primary"
              @click="update()"
            >
              Edit
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
    title: {
      type: String,
      default: ''
    },
    price: {
      type: Number,
      default: null
    },
    stock: {
      type: Number,
      default: null
    }
  },
  data () {
    return {
      bookTitle: this.title,
      bookPrice: this.price,
      bookStock: this.stock
    }
  }
}
</script>
<style scoped>
  .v-card-container{
    padding: 10px;
  }
  .width-one-third{
    width: 30%;
    padding-left: 2.5%;
    padding-right: 2.5%;
  }
</style>
