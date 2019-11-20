import { Component, OnInit } from '@angular/core';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Project';
  public imageSources;
  public imagesURL;

  toggleHeader() {
    $("#sliding-window").slideToggle("slow");
  }

  displayCategory() {
    $(".product-category-dropdown").toggle();
  }

  ngOnInit() {
    this.imageSources = ["https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_960_720.jpg", "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823__340.jpg", "https://image.shutterstock.com/image-photo/mountains-during-sunset-beautiful-natural-260nw-407021107.jpg"]
    this.imagesURL = ["https://image.shutterstock.com/image-vector/moisturizing-cosmetic-products-ad-light-260nw-552433030.jpg", "https://kevinmurphy.com.au/wp-content/uploads/2017/06/product-type-2.png", "https://www.neostrata.com/cms/files/BROWSE_PRODUCTS_US_HEADER_m_V3.jpg", "https://www.incimages.com/uploaded_files/image/970x450/products_364475.jpg", "https://methodhome.com/wp-content/uploads/laundry_p-v2-500x500.png"];
  }

}