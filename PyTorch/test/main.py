import torch as T
from torch import nn
import torch.nn.functional as F

from torchvision import datasets, transforms

trfm = transforms.Compose([
    transforms.ToTensor(),
    transforms.Normalize(0.5, 0.5)
])

trainset = datasets.MNIST("data/MNIST", train=True, transform=trfm, download=True)
valset = datasets.MNIST("data/MNIST", train=False, transform=trfm, download=True)
trainloader = T.utils.data.DataLoader(trainset, 128, shuffle=True)
valloader = T.utils.data.DataLoader(valset, 128, shuffle=True)
