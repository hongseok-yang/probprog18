# CS492 Probabilistic Programming, Spring 2018, KAIST 

This is a webpage of the course "CS492 Probabilistic Programming", which is offered at the KAIST CS department in the spring of 2018. The webpage will contain links to lecture slides and other course-related materials.

Probabilistic programming refers to the idea of developing a programming language for writing and reasoning about probabilistic models from machine learning and statistics. Such a language comes with the implementation of several generic inference algorithms that answer various queries about the models written in the language, such as posterior inference and marginalisation. By providing these algorithms, a probabilistic programming language enables data scientists to focus on designing good models based on their domain knowledge, instead of building effective inference engines for their models, a task that typically requires expertise in machine learning, statistics and systems. Even experts in machine learning and statistics may get benefitted from such a probabilistic programming system because using the system they can easily explore highly advanced models.

This course has two goals. The first is to help students to be a good user of an expressive probabilistic programming language.  Throughout the course, we will use a particular language, called [Anglican](http://www.robots.ox.ac.uk/~fwood/anglican/), but we will emphasise general principles that apply to a wide range of existing probabilistic programming systems. The second goal is to expose the students to recent exciting results in probabilistic programming, which come from machine learning, statistics, programming languages, and probability theory.  Through a group project, students will be given a chance to study such a result
and to play with it.

## 1. Important Announcements

## 2. Logistics

#### Evaluation

* Final exam (40%). Project (40%). Homework (20%).

#### Teaching Staffs

* Lecturer: [Hongseok Yang](https://cs.kaist.ac.kr/people/view?idx=552&kind=faculty&menu=160) (email: hongseok.yang@kaist.ac.kr, office hour: 6:00pm - 7:00pm on Tuesday at the room 3403 in the E3-1 building)
* TA: Kwonsoo Chae (email: kwonsoo.chae@gmail.com)

#### Place and Time

* Place: room 111 in the N1 building
* Time: 10:30am - 11:45am on Tuesday and Thursday from February 27 2018 until June 14 2018.
* Final Exam: 9:00am - 11:00am on June 14 2018 (Thursday) at the room 111 in the N1 building.

#### Online Discussion

* We will use KLMS. 

## 3. Tentative Plan

* 02/26 (Tue) - Introduction. 
* __**03/01 (Thu) - NO LECTURE.**__
* 03/06 (Tue) - Basics of Clojure and Tiny Bit of Anglican.
* 03/08 (Thu) - Posterior Inference, Basics of Anglican, and Importance Sampling. 
* 03/13 (Tue) - Posterior Inference, Basics of Anglican, and Importance Sampling. 
* 03/15 (Thu) - Generative Modelling with Anglican. 
* 03/20 (Tue) - Generative Modelling with Anglican. 
* 03/22 (Thu) - Generative Modelling with Anglican. 
* 03/27 (Tue) - Markov Chain Monte Carlo. 
* 03/29 (Thu) - Markov Chain Monte Carlo. 
* 04/03 (Tue) - Markov Chain Monte Carlo. 
* 04/05 (Thu) - Basics of Operational Semantics.
* 04/10 (Tue) - Specifying Inference Algorithms using Operational Semantics.
* 04/12 (Thu) - Specifying Inference Algorithms using Operational Semantics.
* __**04/17 (Tue), 04/19 (Thu) - NO LECTURES.**__
* 04/24 (Tue) - Specifying Inference Algorithms using Operational Semantics.
* 04/26 (Thu) - Stochastic Variational Inference.
* 05/01 (Tue) - Stochastic Variational Inference.
* 05/03 (Thu) - Stochastic Variational Inference.
* 05/08 (Tue) - Denotational Semantics of Probabilistic Programs.
* 05/10 (Thu) - Denotational Semantics of Probabilistic Programs. 
* 05/15 (Tue) - Denotational Semantics of Probabilistic Programs. 
* 05/17 (Thu) - Denotational Semantics of Probabilistic Programs.
* __**05/22 (Tue) - NO LECTURE.**__
* 05/24 (Thu) - Amortised Inference and Model Learning.
* 05/29 (Tue) - Amortised Inference and Model Learning.
* 05/31 (Thu) - Amortised Inference and Model Learning.
* 06/05 (Tue) - Student Presentation
* 06/07 (Thu) - Student Presentation
* __**06/12 (Tue), 06/14 (Thu) - NO LECTURES.**__

## 4. Studying Materials

Studying the lecture slides and notes and the homework exercises of the course is likely to be the most time-efficient way to catch up with this course. Also, at each lecture, we will give students pointers to the related papers. If a student does not understand a certain concept, we encourage him or her to look it up in the Internet. We typically do this when we encounter a similar problem. In our case, Wikipedia, lecture notes or survey articles have helped us the most.

The next best option is to read the following draft book on probabilistic programming:

1. "An Introduction to Probabilistic Programming" by Jan-Willem van de Meent, Brooks Paige, Hongseok Yang and Frank Wood. If other authors allow, Hongseok will distribute the book to the students.

Reading this book will give a broader view on probabilistic programming and much deeper understanding into its inference algorithms and their implementations.

If a student feels that she or he lacks background knowledge on machine learning, we recommend him or her to have a look at the following online materials.

2. The online book "[Probabilistic Programming and Bayesian Methods for Hackers](https://github.com/CamDavidsonPilon/Probabilistic-Programming-and-Bayesian-Methods-for-Hackers)" describes Bayesian Machine Learning using a probabilistic programming system called PyMC. Hongseok found this book easy to follow and good at explaining basics and intuitions. 
3. A more standard reference on machine learning is Bishop's book "Pattern Recognition and Machine Learning".

Two good ways to understand probabilistic programming are to try a wide range of examples and to understand common implementation techniques for probabilistic programming languages. The following documents provide such examples or explain those techniques.

4. [Anglican website](https://probprog.github.io/anglican/index.html). In particular, students will learn a lot by trying examples in the site.
5. [Forestdb.org](http://forestdb.org/) is a great source of interesting probabilistic programs. 
6. [Edward tutorial website](http://edwardlib.org/tutorials/) and [Pyro example website](http://pyro.ai/examples/). Edward and Pyro are so called deep probabilistic programming languages that attempt to combine deep learning and probabilistic programming. These web pages contain interesting examples that one can try using these languages. 
7. Goodman and Stuhlmuller's book "[The Design and Implementation of Probabilistic Programming Languages](http://dippl.org/)". This web-based book describes the implementation of WebPPL, a probabilistic programming language on top of JavaScript. Many techniques in the book are general and apply to other probabilistic programming languages.
