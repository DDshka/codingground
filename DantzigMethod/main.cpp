#include <iostream>
#include <limits.h>
#include <vector>
#include <cstring>
#include "DFM.h"

using namespace std;

int main()
{
    setlocale(LC_ALL, "Russian");
    
	uint** inputMatrix = nullptr;
	uint size = 0;
	cout << "Please do not mistakes in the input matrix\nTo mark the infinity type \"inf\"" << endl;
	readMatrix<uint>(inputMatrix, size);

	/*//sample
	uint** inputMatrix = new uint*[4];
	inputMatrix[0] = new uint[4] { 0, 1, 2, 1 };
	inputMatrix[1] = new uint[4] { 2, 0, 7, infinity };
	inputMatrix[2] = new uint[4] { 6, 5, 0, 2 };
	inputMatrix[3] = new uint[4] { 1, infinity, 4, 0 };
	*/

	DantzigFloydMethod<uint> DFM(inputMatrix, size);
	for (uint k = 0; k < size + 1; k++)
	{
		cout << "\tD" << k << endl;
		uint** outMatrix = DFM.getMatrix(k);
		for (uint i = 0; i < size; i++)
		{
			for (uint j = 0; j < size; j++)
				cout << outMatrix[i][j] << " ";
			cout << endl;
		}
		cout << "____________" << endl << endl;
	}

	int** wayMatrix = DFM.getWays();

	cout << "All possible ways with the least costs" << endl;

	for (uint i = 0; i < size; i++)
		for (uint j = 0; j < size; j++)
		{
			uint k = wayMatrix[i][j];
			if (k != -1)
			{
				cout << i + 1;
				while (k != -1)
				{
					cout << " -> " << k + 1;
					k = wayMatrix[k][j];
				}
				cout << endl;
			}
		}

	while (true)
	{
	    cout << "Do you need to count one more matrix? (y/n)\t";
	    char* inputChar = new char;
	    cin >> inputChar;
	    if (inputChar[0] == 'y') 
	        main();
	    else 
	        break;
	}

	return 0;
}

