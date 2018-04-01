# CS492 Probabilistic Programming, Spring 2018, KAIST 

This is a webpage of the course "CS492 Probabilistic Programming", which is offered at the KAIST CS department in the spring of 2018. The webpage will contain links to lecture slides and other course-related materials.

Probabilistic programming refers to the idea of developing a programming language for writing and reasoning about probabilistic models from machine learning and statistics. Such a language comes with the implementation of several generic inference algorithms that answer various queries about the models written in the language, such as posterior inference and marginalisation. By providing these algorithms, a probabilistic programming language enables data scientists to focus on designing good models based on their domain knowledge, instead of building effective inference engines for their models, a task that typically requires expertise in machine learning, statistics and systems. Even experts in machine learning and statistics may get benefited from such a probabilistic programming system because using the system they can easily explore highly advanced models.

This course has two goals. The first is to help students to be a good user of an expressive probabilistic programming language.  Throughout the course, we will use a particular language, called [Anglican](http://www.robots.ox.ac.uk/~fwood/anglican/), but we will emphasise general principles that apply to a wide range of existing probabilistic programming systems. The second goal is to expose the students to recent exciting results in probabilistic programming, which come from machine learning, statistics, programming languages, and probability theory.  

## 1. Important Announcements

#### [April 1] [Homework2](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework2/homework2-questions.pdf) is out. 

The due date is 2:00pm on April 23 2018 (Monday). Submit your solutions by putting them in the homework submission box in the third floor of the E3-1 building.


#### [March 24] Reminder of the group project pitch on April 5.

During our lecture time on the 5 of April, we will have a project-pitch session. This means that each of the 8 project groups in Track A will give a 7 minute presentation on what the group plans to do, and get feedback from others in the lecture for about 3 minutes. So, please pick a topic for your group project, and do prepare a presentation. We will use the order in the course webpage to decide the order of presentations:

1. Dongkyeun Kim, Dongkwan Kim and Jungyeun Moon
2. Kwonsoo Chae, Seongmin Lee and HyungJin Lim
3. Youngkyeong Bae, Kyoungyeon Lee and Sunghui Lee.
4. Faycal Baki, Timo Moilanen and Jonas Nikula.
5. Changyoung Koh.
6. Jiseok Kim, Jongwan Lee and Jaeyoung Whang.
7. Dohyeong Kim, Kangsan Kim and Ohjun Kwon.
8. Kwanwoo Kim, Youngjo Min and Sungje Moon.

This is a tentative plan. Some students might cancel their registrations for this course in the next few weeks. So, there might be some changes in the plan.

#### [March 14] TA office hour

Kwonsoo will have office hours from 4:00pm to 6:00pm on Tuesday at the room 3431 in the E3-1 building (starting from March 20).

#### [March 10] [Homework1](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework1/homework1-questions.pdf) is out. 

The due date is 2:00pm on March 30 2018 (Friday). Submit your solutions by putting them in the homework submission box in the third floor of the E3-1 building.

#### [February 28] One of the two subjects in Track B, automatic differentation, is taken by a group of four students.

#### [February 27] [Homework0](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework0/homework0.pdf) is out.

You don't have to submit your answer. But we strongly recommend you to try it. This homework will teach you how to run Anglican.

#### [February 27] Project group.

The group project is an important part of this course. Find your project partners by March 13 2018, and inform Hongseok and Kwonsoo by email. Each group should consist of 3-4 students. Finally, if your group wants to go for Track B, contact Hongseok as early as possible by email. Both topics in Track B will be heavy in math.

## 2. Logistics

#### Evaluation

* Final exam (40%). Project (40%). Homework (20%).

#### Teaching Staffs

* Lecturer: [Prof Hongseok Yang](https://cs.kaist.ac.kr/people/view?idx=552&kind=faculty&menu=160) (email: hongseok00@gmail.com, office hour: 6:00pm - 7:00pm on Tuesday at the room 3403 in the E3-1 building)
* TA: Kwonsoo Chae (email: kwonsoo.chae@gmail.com, office hour: 4:00pm - 6:00pm on Tuesday at the room 3431 in the E3-1 building)

#### Place and Time

* Place: room 111 in the N1 building
* Time: 10:30am - 11:45am on Tuesday and Thursday from February 27 2018 until June 14 2018.
* Final exam: 9:00am - 11:00am on June 14 2018 (Thursday) at the room 111 in the N1 building.

#### Online Discussion

* We will use KLMS. 

## 3. Homework

Submit your solutions by putting them in the homework submission box in the third floor of the E3-1 building.

* [Homework0](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework0/homework0.pdf) - Don't submit.
* [Homework1](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework1/homework1-questions.pdf) -  Deadline: 2:00pm on March 30 2018 (Friday). 
* [Homework2](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework2/homework2-questions.pdf) -  Deadline: 2:00pm on April 23 2018 (Monday).

## 4. Tentative Plan

* 02/26 (Tue) - Introduction. [Slides](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture1/Lecture1.pdf). [Homework0](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework0/homework0.pdf).
* __**03/01 (Thu) - NO LECTURE. Independence Movement Day.**__
* 03/06 (Tue) - Basics of Clojure and Tiny Bit of Anglican. [Slides](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture2/Lecture2.pdf). [Gorilla worksheet](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture2/RandomFibLec2.clj). [Programs](https://github.com/hongseok-yang/probprog18/tree/master/Lectures/Lecture2).
* 03/08 (Thu) - Basics of Clojure and Tiny Bit of Anglican. 
* 03/13 (Tue) - Posterior Inference, Basics of Anglican, and Importance Sampling. [Slides](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture3/Lecture3.pdf). [Homework1](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework1/homework1-questions.pdf). [Gorilla worksheet](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture3/PuzlLec3.clj).
* 03/15 (Thu) - Posterior Inference, Basics of Anglican, and Importance Sampling. 
* 03/20 (Tue) - Generative Modelling with Anglican. [Slides](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture4/Lecture4.pdf). [Gorilla worksheet for 2D physics](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture4/PhysicsLec4.clj). [Gorilla worksheet for program induction](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture4/ProgIndLec4.clj). (Note: In order to run the 2D physics example, you will have to copy [bounce.clj](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture4/bounce.clj) to the anglican-user/src directory and replace anglican-user/project.clj by [this file](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture4/project.clj)).
* 03/22 (Thu) - Generative Modelling with Anglican. 
* 03/27 (Tue) - Markov Chain Monte Carlo. [Slides](https://github.com/hongseok-yang/probprog18/blob/master/Lectures/Lecture5/Lecture5.pdf). 
* 03/29 (Thu) - Markov Chain Monte Carlo. 
* 04/03 (Tue) - Markov Chain Monte Carlo. [Homework2](https://github.com/hongseok-yang/probprog18/blob/master/Homework/Homework2/homework2-questions.pdf).
* 04/05 (Thu) - Group Project Pitch.
* 04/10 (Tue) - Specifying Inference Algorithms using Operational Semantics.
* 04/12 (Thu) - Specifying Inference Algorithms using Operational Semantics.
* __**04/17 (Tue), 04/19 (Thu) - NO LECTURES. Midterm Exam.**__
* 04/24 (Tue) - Specifying Inference Algorithms using Operational Semantics.
* 04/26 (Thu) - Stochastic Variational Inference.
* 05/01 (Tue) - Stochastic Variational Inference.
* 05/03 (Thu) - Amortised Inference and Model Learning.
* 05/08 (Tue) - Amortised Inference and Model Learning.
* 05/10 (Thu) - Group Presentation 1: Automatic Differentiation
* 05/15 (Tue) - Group Presentation 2: Normalising Flow
* 05/17 (Thu) - Denotational Semantics of Probabilistic Programs.
* __**05/22 (Tue) - NO LECTURE. Buddha's Birthday.**__
* 05/24 (Thu) - Denotational Semantics of Probabilistic Programs.
* 05/29 (Tue) - Denotational Semantics of Probabilistic Programs.
* 05/31 (Thu) - Denotational Semantics of Probabilistic Programs. 
* 06/05 (Tue) - Student Presentation
* 06/07 (Thu) - Student Presentation
* __**06/12 (Tue), 06/14 (Thu) - NO LECTURES. Final Exam.**__

## 5. Studying Materials

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
7. Goodman and Stuhlmuller's book "[The Design and Implementation of Probabilistic Programming Languages](http://dippl.org/)". This web-based book describes the implementation of [WebPPL](http://webppl.org/), a probabilistic programming language on top of JavaScript. Many techniques in the book are general and apply to other probabilistic programming languages.

## 6. Group Project

A group project is a crucial part of this course. 3-4 students will form a
project group, and they will carry out a project in Track A or in Track B:

1. **Track A**: A group develops an interesting application of Anglican or other probabilistic programming languages. The members of the group may attempt to find an efficient encoding of a highly complex probabilistic model (such as sequence memoizer) in Anglican,  or they may develop a new probabilistic model for a complex data set and analyse the data set, or they may try to find a novel use of probabilistic programming for solving well-known existing problems (such as figuring out secret key in some security protocol).
2. **Track B**: At most two groups will be on this track. We recommend this track only for groups that feel comfortable with advanced mathematics. The goal of a group in this case is to study an advanced research topic on probabilistic programming, to gain deep understanding about it, and to help fellow students acquire the same understanding. Specifically, a group performs an in-depth study on one of two advanced topics, (reverse-mode) automatic differentiation and normalising flow, used in or supported by recent deep probabilistic programming languages such as Edward and Pyro. Then, the group has to teach what it learnt to other students in the course. By teaching, we mean (i) a presentation on the studied topic and (ii) a preparation of reading material and exercise problems. Further information about automatic differentiation and normalising flow is given at the end of this webpage.

#### Group (Track A)

1. Dongkyeun Kim, Dongkwan Kim and Jungyeun Moon 
2. Kwonsoo Chae, Seongmin Lee and HyungJin Lim
3. Youngkyeong Bae, Kyoungyeon Lee and Sunghoi Lee.
4. Faycal Baki, Timo Moilanen and Jonas Nikula.
5. Silap Aliyev and Changyoung Koh.
6. Jiseok Kim, Jongwan Lee and Jaeyoung Whang.
7. Dohyeong Kim, Kangsan Kim and Ohjun Kwon.
8. Kwanwoo Kim, Youngjo Min and Sungje Moon.

#### Group (Track B)

1. Donghoon Ham, Youngkyu Hong, Hangyeol Yu and Sihyeon Yu - automatic differentiation.
2. Hanpil Kang and Hyunwoo Lee - normalising flow.

#### Concrete Tasks

1. **[Deadline: midnight on March 13 (Tue)]** Form a group and inform us by email (Hongseok and Kwonsoo). 
2. **[April 5 (Thu)]** Presentation of each group about its topic.
3. **[May 10 (Thu)]** Presentation on automatic differentiation by a group on track B.
4. **[May 15 (Tue)]** Presentation on normalising flow by a group on track B.
5. **[June 5 (Tue), June 7 (Thu)]** Presentation of group projects.
6. **[Deadline: midnight on June 8 (Fri)]** Submit a report on the project. We recommend each report to be 2-to-4 pages long, although it is fine to write a longer report if needed.

#### Two Topics in Track B

1. **(Reverse-mode) Automatic Differentiation** Automatic differentiation is one of the main driving technologies behind neural nets and deep probabilistic programming languages. Supporting it has been one of the main objectives of Tensorflow and PyTorch, two popular platforms for building neural nets and other machine-learning related software systems. Automatic differentiation is based on nontrivial mathematics; it originates from a non-standard interpretation of mathematical analysis, and its modern generalisation has sometimes been formalised using tools from differential geometry. Pyro, ProbTorch, Edward and Stan heavily use automatic differentiation. A group will have to understand reverse-mode automatic differentiation and explain how it has been or can be used to implement inference algorithms for probabilistic programming languages. Here are a few references that will help a group to find relevant papers.
   1. [Rahul's blog article](https://alexey.radul.name/ideas/2013/introduction-to-automatic-differentiation/). 
   2. [Blog article in Rufflewind's scratchpad](https://rufflewind.com/2016-12-30/reverse-mode-automatic-differentiation).
   3. Baydin et al.'s ["Automatic Differentiation in Machine Learning: a Survey"](https://arxiv.org/pdf/1502.05767.pdf).
   4. Conal Elliott's PEPM18 talk [slides and video](https://github.com/conal/talk-2018-essence-of-ad/blob/master/readme.md).
   5. Automatic differentiation in [PyTorch](http://pytorch.org/tutorials/beginner/blitz/autograd_tutorial.html) and [Tensorflow](https://www.tensorflow.org/versions/r0.12/api_docs/python/train/gradient_computation). There is a short [paper](https://openreview.net/pdf?id=BJJsrmfCZ) about the implementation in PyTorch.
   6. [Autograd](https://github.com/HIPS/autograd) aims at implementation a very flexible version of automatic differentation for python.
   7. [Diffsharp](http://diffsharp.github.io/DiffSharp/) is another well-known implementation for automatic differentation for the F# language.

2. **Normalising Flow** Normalising flow is a powerful technique for building an approximating distribution in variational inference. It has been proposed in the context of solving general machine learning problems, but it has become an important construct, called bijector, in recent probabilistic programming languages Edward and Pyro. Here are a few references that will help a group to start its study on this subject:
   1. Eric Jang's blog articles, [first](https://blog.evjang.com/2018/01/nf1.html) and [second](https://blog.evjang.com/2018/01/nf2.html).
   2. Dillon et al.'s paper ["Tensorflow Distribution"](https://arxiv.org/abs/1711.10604) explains the bijector implementation of normalising flow in the probabilistic programming language Edward. 
   3. [Documentation](http://docs.pyro.ai/en/0.1.2-release/transformed_dist.html#) on bijector and inverse autoregressive flow in Pyro.
   4. Rezende and Mohamed's original paper ["Variational Inference with Normalizing Flows"](https://arxiv.org/abs/1505.05770).
   5. Kingma et al.'s paper ["Improved Variational Inference with Inverse Autoregressive Flow"](http://papers.nips.cc/paper/6581-improved-variational-inference-with-inverse-autoregressive-flow).
   6. Germain et al.'s paper ["MADE: Masked Autoencoder for Distribution Estimation"](https://arxiv.org/abs/1502.03509)
