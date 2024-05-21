import { Component, OnInit } from '@angular/core';

interface Testimonial {
  name: string;
  message: string;
  photoUrl: string;
  ratings: number[]; // Add rating property
}

@Component({
  selector: 'app-testimonials',
  templateUrl: './testimonials.component.html',
  styleUrl: './testimonials.component.css'
})
export class TestimonialsComponent implements OnInit{

  testimonials:Testimonial[]= [
    { name: 'John Doe', message: 'I am extremely satisfied with the home loan service provided by UIBS. The process was smooth and hassle-free.', photoUrl: 'assets/images/testimonial_1.jpg', ratings: [5, 5, 5, 5, 5] },
    { name: 'Jane Smith', message: 'I highly recommend UIBS Bank for anyone looking for a home loan. The staff was helpful and guided me through every step.', photoUrl: 'assets/images/testimonial_3.jpg', ratings: [4, 4, 4, 4, 4] },
    { name: 'Mike Johnson', message: 'Thanks to UIBS Bank, I am now a proud homeowner. Their competitive rates and excellent customer service made it possible.', photoUrl: 'assets/images/testimonial_2.jpg', ratings: [4, 4, 4, 4, 4] },
    { name: 'Emily Brown', message: 'UIBS Bank made the home loan process simple and stress-free. I\'m grateful for their support. By far they are the best in business.', photoUrl: 'assets/images/testimonial_4.jpg', ratings: [4, 4, 4, 4, 4] },
    { name: 'Piyush Barapatre', message: 'The team at UIBS Bank went above and beyond to help me secure my dream home. Highly recommended! 6 stars possible?', photoUrl: 'assets/images/testimonial_5.jpg', ratings: [5, 5, 5, 5, 5] },
    { name: 'Sarah Wilson', message: 'I had a wonderful experience with UIBS Bank. They provided me with all the necessary information and helped me at every step of the home loan process.', photoUrl: 'assets/images/testimonial_7.jpg', ratings: [5, 5, 5, 5, 5] },
  ];

  constructor() { }

  ngOnInit(): void {
  }

  getStarRatings(ratings: number[]): number[] {
    const averageRating = ratings.reduce((total, rating) => total + rating, 0) / ratings.length;
    return Array.from({ length: Math.floor(averageRating) }, (_, index) => index + 1);
  }

  getAverageRating(ratings: number[]): number {
    const sum = ratings.reduce((total, rating) => total + rating, 0);
    return sum / ratings.length;
  }
}
