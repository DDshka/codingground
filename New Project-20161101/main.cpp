#include <iostream>
#include <limits.h>
#include <vector>

#define infinity INT_MAX

using namespace std;

const int numberOfVertexes = 4;
vector<int**> matrixes;
int m = 1;

void readMatrix(int** inputArray, const int size)
{
	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			cin >> inputArray [i][j];
}

void printMatrix(int** outputArray, const int size)
{
	for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size; j++)
			cout << outputArray[i][j] << " ";
		cout << endl;
	}
}

void init2Dparray(int** arr, const int& size)
{
	for (int i = 0; i < size; i++)
		arr[i] = new int[size];
}

void countMatrix()
{
	int** temp_matrix = new int*[numberOfVertexes];
	int z = m - 1; //OVER ZRADA - действительный индекс отличается на -1. Придумать нормальное имя переменной или избавиться от "фичи".
	init2Dparray(temp_matrix, numberOfVertexes);

	for (int i = 0; i < numberOfVertexes; i++)
	{
		for (int j = 0; j < numberOfVertexes; j++)
		{
			/*int a = matrixes[m - 1][i][z];
			int b = matrixes[m - 1][z][j];
			int c = matrixes[m - 1][i][j];*/
			temp_matrix[i][j] = min(matrixes[m - 1][i][z] + matrixes[m - 1][z][j], matrixes[m - 1][i][j]);
		}
	}
	matrixes.push_back(temp_matrix);
	m++;

	//delete [] temp_matrix;
}

int main()
{
	setlocale(LC_ALL, "Russian");

	int** inputMatrix = new int*[numberOfVertexes];
	inputMatrix[0] = new int[numberOfVertexes] { 0, 1, 2, 1 };
	inputMatrix[1] = new int[numberOfVertexes] { 2, 0, 7, infinity };
	inputMatrix[2] = new int[numberOfVertexes] { 6, 5, 0, 2 };
	inputMatrix[3] = new int[numberOfVertexes] { 1, infinity, 4, 0 };

	matrixes.push_back(inputMatrix);

	//f(x)
	//D(m, ij) = min(d(m-1, im) + d(m-1, mj), d(m-1, ij))

	for (int i = 1; i < numberOfVertexes + 1; i++)
	{
		countMatrix();
		
		cout << "\tMatrix D" << i << endl << endl;
		
		printMatrix(matrixes[i], numberOfVertexes);
		
		cout  << "________" << endl << endl;
	}

	system("pause");

	return 0;
}