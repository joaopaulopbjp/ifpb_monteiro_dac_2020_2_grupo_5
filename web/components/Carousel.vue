<template>
  <v-carousel
    cycle
    height="200"
    hide-delimiter-background
    show-arrows-on-hover
    class="width-fill"
  >
    <template #prev="{ on, attrs }">
      <v-btn
        color="primary"
        v-bind="attrs"
        v-on="on"
      >
        &#60;
      </v-btn>
    </template>
    <template #next="{ on, attrs }">
      <v-btn
        color="primary"
        v-bind="attrs"
        v-on="on"
      >
        &#62;
      </v-btn>
    </template>
    <v-carousel-item
      v-for="(product, i) in products"
      :key="i"
    >
      <v-sheet
        color="background"
        height="100%"
        elevation="10"
      >
        <v-row
          class="fill-height"
          align="center"
          justify="center"
        >
          <Product
            :title="product.title"
            :price="product.price"
          />
        </v-row>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
</template>
<script>
import Product from '~/components/Product'
export default {
  components: [
    Product
  ],
  data () {
    return {
      products: [
        {
          title: 'book1',
          price: 10.5
        },
        {
          title: 'book3',
          price: 10.5
        },
        {
          title: 'book2',
          price: 10.5
        }
      ]
    }
  }
}
</script>
<style scoped>
  .width-fill{
    min-width: 77vmax;
  }
</style>
