#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <utility>

using namespace std;


void printMatrix(int arr[5][6]) {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
	cout << "\n";

	for (int i = 0; i < 5; i++) {
		cout << arr[i][5] << " ";
	}
	cout << "\n";
	cout << "\n";
}

int main() {
	int matrix[5][6];
	int sus = 120;

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			matrix[i][j] = sus--;
		}
	}

	for (int i = 0; i < 5; i++) {
		matrix[i][5] = 0; 
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			matrix[i][5] += matrix[i][j];
		}
	}

	printMatrix(matrix);


	for (int k = 0; k < 5 - 1; k++) {
		for (int i = 0; i < 5 - 1 - k; i++) {
			if (matrix[i][5] > matrix[i + 1][5]) {
				for (int j = 0; j < 5; j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][j + 1];
					matrix[i][j + 1] = temp;
				}
			}
		}
	}

	for (int k = 0; k < 5 - 1; k++) {
		for (int i = 0; i < 5 - 1 - k; i++) {
			if (matrix[i][5] > matrix[i + 1][5]) {
				int temp = matrix[i][5];
				matrix[i][5] = matrix[i + 1][5];
				matrix[i + 1][5] = temp;
			}
		}
	}

	printMatrix(matrix);
}