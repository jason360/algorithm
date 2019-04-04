package com.yawasoft.algorithm.tsp;

/**
 * Given a list of cities and the distances between each pair of cities,
 * what is the shortest possible route that visits each city and returns to the origin city?
 *
 * NP-complete problem
 * A decision problem C is NP-complete if:
 * 1. C is in NP, and
 * 2. Every problem in NP is reducible to C in polynomial time.
 * C can be shown to be in NP by demonstrating that a candidate solution to C can be verified in polynomial time.
 *
 * Often, the model is a complete graph (i.e. each pair of vertices is connected by an edge).
 * If no path exists between two cities, adding an arbitrarily long edge will complete the graph without affecting the optimal tour.
 *
 * Exact Algorithm: O(2^n)
 * Heuristic and approximation algorithms: e.g., Nearest Neighbor Theta(log|V|)
 */
public class TravellingSalesmanProblem {
}
