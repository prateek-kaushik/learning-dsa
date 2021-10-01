package com.prateek.learning.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphDS {
	int[][] graph;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter vertices:");
		int vertices = in.nextInt();

		GraphDS obj = new GraphDS();
		obj.graph = new int[vertices][];

		for (int i = 0; i < vertices; i++) {
			System.out.println("Enter number of adj vertices for vertix:" + i);
			int adj = in.nextInt();
			obj.graph[i] = new int[adj];
			System.out.println("Enter adj vertices for " + i);
			for (int j = 0; j < adj; j++) {
				obj.graph[i][j] = in.nextInt();
				System.out.print(" ");
			}
		}

//		for (int i = 0; i < obj.graph.length; i++) {
//			System.out.print(i + " --> ");
//			for (int j = 0; j < obj.graph[i].length; j++) {
//				System.out.print(obj.graph[i][j] + ", ");
//			}
//			System.out.println();
//		}

//		obj.bfs(0, vertices - 1);

//		boolean[] visited = new boolean[vertices];
//		visited[0] = true;
//		obj.dfsRec(0, vertices - 1, 0, visited);

		obj.dfsStack(0, vertices - 1);
	}

	public void bfs(int start, int end) {
		boolean[] visited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			result.add(curr);

			if (curr == end) {
				break;
			}

			boolean flag = false;
			for (int adj : graph[curr]) {
				if (!visited[adj]) {
					flag = true;
					visited[adj] = true;
					queue.add(adj);
				}
			}
			if (!flag) {
				result.remove(result.size() - 1);
			}
		}

		int count = 0;
		while (count < result.size()) {
			System.out.print(result.get(count) + "-->");
			count++;
		}
	}

	public boolean dfsRec(int start, int end, int curr, boolean[] visited) {
		System.out.println("curr=" + curr);
		if (curr == end) {
			return true;
		}

		for (int c : graph[curr]) {
			System.out.println("c is " + c + ", visited=" + visited[c]);
			if (!visited[c]) {
				visited[c] = true;
				boolean found = dfsRec(start, end, c, visited);
				if (found) {
					System.out.println("returning true");
					return true;
				}
			}
		}
		System.out.println("returning false");
		return false;
	}

	public void dfsStack(int start, int end) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.length];
		int[] parent = new int[graph.length];

		stack.push(start);
		visited[start] = true;
		parent[start] = -1;

		while (!stack.isEmpty()) {
			int curr = stack.pop();
			if (curr == end) {
				System.out.println("found end");
				break;
			}
			for (int c : graph[curr]) {
				if (!visited[c]) {
					visited[c] = true;
					stack.push(c);
					parent[c] = curr;
				}
			}
		}

		System.out.print(end + "<--");
		int p = parent[end];
		while (p != -1) {
			System.out.print(p + "<--");
			p = parent[p];
		}
	}
}
