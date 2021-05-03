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
            v-model="bookTitle"
            :rules="titleRules"
            label="Book's title"
            required
          />
          <br>
          <v-text-field
            v-model="bookSubtitle"
            :rules="subtitleRules"
            label="Book's subtitle"
          />
          <br>
          <v-text-field
            v-model="bookDescription"
            label="Book's description"
          />
          <br>
          <v-row>
            <v-text-field
              v-model="bookIsbn"
              :rules="isbnRules"
              label="Book's ISBN"
              class="width-one-third"
            />
            <v-spacer />
            <v-text-field
              v-model.number="bookYear"
              :rules="yearRules"
              type="number"
              label="Book's year"
              class="width-one-third"
            />
          </v-row>
          <br>
          <v-row>
            <v-text-field
              v-model.number="bookStock"
              :rules="stockRules"
              type="number"
              label="Book's stock quantity"
              class="width-one-third"
            />
            <v-spacer />
            <v-text-field
              v-model.number="bookPrice"
              :rules="priceRules"
              type="number"
              step="0.01"
              label="Book's price"
              class="width-one-third"
            />
          </v-row>
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
    title: {
      type: String,
      default: ''
    },
    subtitle: {
      type: String,
      default: ''
    },
    description: {
      type: String,
      default: ''
    },
    isbn: {
      type: String,
      default: ''
    },
    year: {
      type: Number,
      default: null
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
      bookSubtitle: this.subtitle,
      bookDescription: this.description,
      bookIsbn: this.isbn,
      bookYear: this.year,
      bookPrice: this.price,
      bookStock: this.stock,
      titleRules: [
        v => !v || /^(?=.{1,})/.test(v) || 'Book\'s title must contains at least 1 character.'
      ],
      subtitleRules: [
        v => !v || /^(?=.{1,})/.test(v) || 'Book\'s subtitle must contains at least 1 character.'
      ],
      isbnRules: [
        v => !v || /^(?=[0-9])/.test(v) || 'ISBN must contain only numbers.'
      ],
      yearRules: [
        v => !v || /^(?=[0-9])/.test(v) || 'Year must contain only numbers.'
      ],
      priceRules: [
        v => !v || /^(?=[0-9])/.test(v) || 'Price must contain only numbers.'
      ]
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
